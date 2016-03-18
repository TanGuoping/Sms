package com.example.smssender;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SmsStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		if(this.getResultCode()== Activity.RESULT_OK){
			
			Toast.makeText(context, "SMS send successfully", Toast.LENGTH_SHORT).show();
			
		}
		
		else{
			Toast.makeText(context, "SMS send unsuccessfully", Toast.LENGTH_SHORT).show();
		}

	}

}
