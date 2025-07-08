package com.example.cab_booking_driver;

  
import java.io.DataInputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;




import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class driver_home extends Activity {
	 ImageView search_cab,view_booking,payment;
	TextView search_cab1,view_booking1,payment1;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_home);
		
		search_cab = (ImageView) findViewById(R.id.imageView1);
		view_booking = (ImageView) findViewById(R.id.imageView12);
		payment = (ImageView) findViewById(R.id.imageView1233);
	 		
				
		search_cab1 = (TextView) findViewById(R.id.txt1);
		view_booking1 = (TextView) findViewById(R.id.txt2);
		payment1 = (TextView) findViewById(R.id.txt2dfd);
		 
		
		
		
	 
	
		 
		search_cab.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_new_request.class);
		         startActivity(in);	
			 				
			}
        });
		search_cab1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_new_request.class);
		         startActivity(in);	
			 				
			}
        });
		
		view_booking.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_trip_details.class);
		         startActivity(in);	
			 				
			}
        });
		
		view_booking1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_trip_details.class);
		         startActivity(in);	
			 				
			}
        });
		 
		payment.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_payment.class);
		         startActivity(in);	
			 				
			}
        });
		
		
		payment1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), driver_payment.class);
		         startActivity(in);	
			 				
			}
        });
		/*
		logout.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				finish();
			 				
			}
        });
		logout1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				finish();
			 				
			}
        });*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	boolean doubleBackToExitPressedOnce = false;

	@Override
	public void onBackPressed() {
	    if (doubleBackToExitPressedOnce) {
	        super.onBackPressed();
	        return;
	    }
	        
	    this.doubleBackToExitPressedOnce = true;
	    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
	        
	    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
	        
	        @Override
	        public void run() {
	            doubleBackToExitPressedOnce=false;                       
	        }
	    }, 2000);
	} 
}
