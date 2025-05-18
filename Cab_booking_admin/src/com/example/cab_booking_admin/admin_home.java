package com.example.cab_booking_admin;

  
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

public class admin_home extends Activity {
	 ImageView add_police,add_driver;
	TextView add_police1,add_driver1;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home);
		
		add_police = (ImageView) findViewById(R.id.imageView1);
		add_driver = (ImageView) findViewById(R.id.imageView12);
	 		
				
		add_police1 = (TextView) findViewById(R.id.txt1);
		add_driver1 = (TextView) findViewById(R.id.txt2);
		 
		
		
		
	 
	
		 
		add_police.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_add_police.class);
		         startActivity(in);	
			 				
			}
        });
		add_police1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_add_police.class);
		         startActivity(in);	
			 				
			}
        });
		
		add_driver.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_add_driver.class);
		         startActivity(in);	
			 				
			}
        });
		
		add_driver1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_add_driver.class);
		         startActivity(in);	
			 				
			}
        });
		/*
		return_book.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_return_book.class);
		         startActivity(in);	
			 				
			}
        });
		
		
		bklist.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_book_details.class);
		         startActivity(in);	
			 				
			}
        });
		
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
