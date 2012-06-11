package com.arkea.client.android.activities;

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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arkea.client.android.R;
import com.arkea.thrift.data.utilisateur.Utilisateur;
import com.arkea.thrift.service.chatroom.ChatRoomService;

public class AndroThriftChatActivity extends Activity {
    
	 
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Defining the click handler */
        View.OnClickListener loginHandler = new View.OnClickListener() {    		
    		public void onClick(View v) {	
    			sendLogin();
    		}
    	};
        
    	/* Adding click handler to button */
        Button buttonLogin = (Button)findViewById(R.id.loginBtn);
        buttonLogin.setOnClickListener(loginHandler);  
    }
    
    private void sendLogin() {
    	
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
           new SendLogin().execute();
        } else {
                //TO-DO
        }
    }
    
    private class SendLogin extends AsyncTask<Void, Void, Void> {
    
		@Override
		protected Void doInBackground(Void... params) {
			
	    	TTransport transport;
	    	TProtocol protocol;
	    	ChatRoomService.Client client;
	    	Utilisateur user = new Utilisateur();
	    	
	    	user.setPseudo(((EditText)findViewById(R.id.loginFld)).getText().toString());
	    	user.setMotdepasse(((EditText)findViewById(R.id.passwordFld)).getText().toString());
	    	
	    	try {
				transport = new THttpClient("http://192.168.0.31:8080/ChatRoomServer/chatroom/");
				protocol = new TJSONProtocol(transport);
				client = new ChatRoomService.Client(protocol);
				client.enregistrerUtilisateur(user);
				
				
			} catch (TTransportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	finally {
	    		return null;
	    	}
	    	
	    }


    }   
}