package com.example.notificationeg;

import android.location.GpsStatus.NmeaListener;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NotifyActivity extends Activity 
{
	Button start,clear;
	Notification noti;
	private static final int NOTIFICATION_ID =1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notify);
		final NotificationCompat.Builder builder = 
				new NotificationCompat.Builder(this)
				.setContentTitle("JOJO Birthday !")
				.setContentText("Today is your Cousin birthday Wish him without fail")
				.setTicker("Updated Message Alert")
				.setSmallIcon(R.drawable.birth);
		
		start =(Button)findViewById(R.id.button1);
		
		final TaskStackBuilder stak = TaskStackBuilder.create(this);
		
		start.setOnClickListener(new View.OnClickListener() 
		{			
			@Override
			public void onClick(View arg0) 
			{
				start.setBackgroundColor(0xFF00FF00);
				Intent in = new Intent();
				
		/* The stack builder object will contain an artificial back stack 
		for the started Activity.This ensures that navigating backward from 
		the Activity leads out of your application to the Home screen.*/
				
				stak.addParentStack(NotifyActivity.class);
				
		// Adds the Intent that starts the Activity to the top of the stack
				stak.addNextIntent(in);
			
				PendingIntent pen = stak.getPendingIntent(0, 
			    		  PendingIntent.FLAG_UPDATE_CURRENT);
				
				builder.setContentIntent(pen);
				
				NotificationManager nm = (NotificationManager)
						getSystemService(Context.NOTIFICATION_SERVICE);
				nm.notify(1, builder.build());	
				
			}			
		});
		//start.setBackgroundColor(0xffcccccc);
				
		
		clear =(Button)findViewById(R.id.button2);
		
		clear.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View arg0) 
			{
				NotificationManager nm = (NotificationManager)
						getSystemService(Context.NOTIFICATION_SERVICE);
				nm.cancel(1);
				
			}
		});
		
}
}
