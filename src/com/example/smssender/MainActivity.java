package com.example.smssender;

import org.apache.http.NameValuePair;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	
	private TextView to;
	private TextView content;
	private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        
        to = (TextView) findViewById(R.id.to);
        content = (TextView) findViewById(R.id.content);
        send = (Button) findViewById(R.id.send);
        
        send.setOnClickListener(this);
        
        
       
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String address = to.getText().toString();
		String message = content.getText().toString();
		
		SmsManager manager = SmsManager.getDefault();
		
		Intent intent = new Intent("SENT_SMS");
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent, 0);
		
		Log.d("address",address);
		Log.d("message",message);
		
		if(! address.equals("") && !message.equals("")){
			manager.sendTextMessage(address, null, message, pi, null);
			
			content.setText("");
		}
		
		else{
			Toast.makeText(this, "address or message is null", Toast.LENGTH_SHORT).show();
		}
		
		
		
	}

 
}
