package org.lostinbrittany.androTestProject.P01;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AndroTestProjectActivity extends Activity {

	//LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
	ArrayList<SpannableStringBuilder> listItems=new ArrayList<SpannableStringBuilder>();

	//DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
	ArrayAdapter<SpannableStringBuilder> adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        
        ListView theList = (ListView)findViewById(R.id.chatPanel);
        
        adapter=new ArrayAdapter<SpannableStringBuilder>(this, R.layout.list_item, listItems);
        theList.setAdapter(adapter); 
        
        Button buttonSend = (Button)findViewById(R.id.sendButton);
        buttonSend.setOnClickListener(sendHandler);        
    }

    
    View.OnClickListener sendHandler = new View.OnClickListener() {
		
		public void onClick(View v) {
			
			addItems();
			
						
		}
	};
	
	
	//METHOD WHICH WILL HANDLE DYNAMIC INSERTION
	public void addItems() {
		
		SpannableStringBuilder sb = new SpannableStringBuilder();
		
		CharSequence user = "Horacio";
		CharSequence message = "Hellow world";
		
		sb.append(user);
		sb.setSpan(new ForegroundColorSpan(android.graphics.Color.RED), sb.length()-user.length(), sb.length(), 0);
		
				
		sb.append("\n  ").append(message);		
		sb.setSpan(new RelativeSizeSpan(1.25f), sb.length()-message.length(), sb.length(), 0);
		sb.append("\n");
		
		listItems.add(sb);
		adapter.notifyDataSetChanged();
	}

    
    
}