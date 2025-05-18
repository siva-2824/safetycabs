package com.example.cab_booking_admin;
 
 
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class home extends Activity {
	ImageView i1,i2;
	TextView t1,t2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		i1 = (ImageView) findViewById(R.id.imageView1);
		i2 = (ImageView) findViewById(R.id.imageView12);
		 
		t1 = (TextView) findViewById(R.id.txt1);
		t2 = (TextView) findViewById(R.id.txt2);
	 
		i1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_login.class);
		         startActivity(in);	
			 				
			}
        });
		t1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), admin_login.class);
		         startActivity(in);	
			 				
			}
        });
		
		
		i2.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
			   	
				 Intent in = new Intent(getApplicationContext(), police_login.class);
		         startActivity(in);				
			}
        });
		t2.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				
				 Intent in = new Intent(getApplicationContext(), police_login.class);
		         startActivity(in);		
			 				
			}
        });
		
	 	
//		i3.setOnClickListener(new OnClickListener() 
//        {
//
//			@Override
//			public void onClick(View arg0) {
//				 Intent in = new Intent(getApplicationContext(), user_login.class);
//		         startActivity(in);		
//			 				
//			}
//        });
//		t3.setOnClickListener(new OnClickListener() 
//        {
//
//			@Override
//			public void onClick(View arg0) {
//				 Intent in = new Intent(getApplicationContext(), user_login.class);
//		         startActivity(in);		 
//			 				
//			}
//        });
		
		 
		 
	 
    	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
