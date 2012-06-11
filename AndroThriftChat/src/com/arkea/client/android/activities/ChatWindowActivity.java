package com.arkea.client.android.activities;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.arkea.client.android.R;
import com.arkea.client.android.adapter.MessageAdapter;
import com.arkea.thrift.data.message.Message;
import com.arkea.thrift.data.utilisateur.Utilisateur;
import com.arkea.thrift.service.chatroom.ChatRoomService;

public class ChatWindowActivity extends Activity {

	Utilisateur user = new Utilisateur();
	
	//List of Messages which will serve as list items
	List<Message> listItems=new LinkedList<Message>();

	//Defining Message adapter which will handle data of ListView
	MessageAdapter adapter;
	
	//TimerTask for scanning
	TimerTask timerTask;
	Timer timer= new Timer();
	final Handler handler = new Handler();


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.chat_window);
        
        Bundle bundle = getIntent().getExtras();
        user = (Utilisateur)bundle.get("user");
        
        adapter=new MessageAdapter(getApplicationContext(), listItems);
        ListView theList = (ListView)findViewById(R.id.messageLst);
        if (null == theList ) {
        	Log.d("Putain","The list is null");
        }
        Log.d("Test",theList.getClass().getName());
        theList.setAdapter(adapter);
        
        /* Defining the click handler */
        View.OnClickListener sendHandler = new View.OnClickListener() {    		
    		public void onClick(View v) {	
    			sendMessage();
    		}
    	};
        
    	/* Adding click handler to button */
        Button buttonLogin = (Button)findViewById(R.id.sendBtn);
        buttonLogin.setOnClickListener(sendHandler);  
    }
    
    
    @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		stopScan();
	}


	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		startScan();
	}


	private void listenForMessages() {
    	
    }
    
    private void sendMessage() {
    
    	Message message = new Message();
    	
    	message.setUtilisateur(user);
    	EditText messageBox = (EditText)findViewById(R.id.newMessage);
    	message.setContenu(messageBox.getText().toString());
    	
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
           new SendMessage(message).execute();
           messageBox.setText("");
        } else {
                //TO-DO
        }
    }

    private class SendMessage extends AsyncTask<Void, Void, Void> {
        
    		Message message;
    	    
    		public SendMessage(Message aMessage) {
    	    	super();
    	    	message = aMessage;
    	    }
    	    
    		@Override
    		protected Void doInBackground(Void... params) {
    			
    	    	TTransport transport;
    	    	TProtocol protocol;
    	    	ChatRoomService.Client client;
    	    	
    	    	try {
    				transport = new THttpClient("http://192.168.0.31:8080/ChatRoomServer/chatroom/");
    				protocol = new TJSONProtocol(transport);
    				client = new ChatRoomService.Client(protocol);
    				client.envoyerMessage(message);
    				Log.d("Sending message", "Done");
    				
    			} catch (TTransportException e) {
    				Log.e("Sending message", "Thrift exception", e);
    				return null;
    			} catch (TException e) {
    				Log.e("Sending message", "Thrift exception", e);
    				return null;
    			} catch (Exception e) {
    				Log.e("Sending message", "Thrift exception", e);
    				return null;
    			}
    	    	return null;

    	    	
    	    	
    	    }


        }   

    private void startScan() {
    	timerTask = new TimerTask() {
    		public void run() {
    			handler.post(new Runnable() {
    				public void run() {
    					
    	    	    	new ReadMessages().execute();
    	    	    	adapter.notifyDataSetChanged();
    					Log.d("TIMER", "Timer set off");
    				}
    			});
    		}};


    		timer.schedule(timerTask, 500, 5000); 

    }

    public void stopScan(){

    	if(timerTask!=null){
    		Log.d("TIMER", "timer canceled");
    		timerTask.cancel();
    	}

    }
    private class ReadMessages extends AsyncTask<Void, Void, Void> {
        
		Message message;
	    
	    
		@Override
		protected Void doInBackground(Void... params) {
			TTransport transport;
	    	TProtocol protocol;
	    	ChatRoomService.Client client;
	    	
	    	try {
				transport = new THttpClient("http://192.168.0.31:8080/ChatRoomServer/chatroom/");
				protocol = new TJSONProtocol(transport);
				client = new ChatRoomService.Client(protocol);
				List<Message> receivedList = client.getListeMessage();
				for (int i =listItems.size(); i< receivedList.size() ; i++) {
					listItems.add(receivedList.get(i));
				}
				Log.d("Read messages", "Done");
				StringBuilder sb = new StringBuilder();
				for (Message item : listItems) {
					sb.append("'").append(item.getUtilisateur().getPseudo()).append("' : '").append(item.getContenu()).append("'");
				}
				Log.d("Liste Messages", sb.toString());
				return null;
				
			} catch (TTransportException e) {
				Log.e("Read messages", "Thrift exception", e);
				return null;
			} catch (TException e) {
				Log.e("Read messages", "Thrift exception", e);
				return null;
			} catch (Exception e) {
				Log.e("Sending message", "Thrift exception", e);
				return null;
			}
		}
    }
}

