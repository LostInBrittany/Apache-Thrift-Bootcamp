package org.lostinbrittany.androTestProject.P01;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndroTestProjectActivity extends Activity {
	

	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button buttonSend = (Button)findViewById(R.id.sendButton);
        buttonSend.setOnClickListener(sendHandler);        
    }

    
    View.OnClickListener sendHandler = new View.OnClickListener() {
		
		public void onClick(View v) {
			
			
			SpannableStringBuilder sb = new SpannableStringBuilder();
			
			CharSequence user = "Horacio";
			CharSequence message = "Hellow world";
			
			sb.append(user);
			sb.setSpan(new ForegroundColorSpan(android.graphics.Color.RED), sb.length()-user.length(), sb.length(), 0);
			
					
			sb.append("\n  ").append(message);		
			sb.setSpan(new RelativeSizeSpan(1.25f), sb.length()-message.length(), sb.length(), 0);
			sb.append("\n");
			
			TextView chatPanel = (TextView)findViewById(R.id.chatPanel);
			
			chatPanel.append(sb);
		}
	};
    
    
}