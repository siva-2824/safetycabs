package com.example.cab_booking_women;
  
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
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class user_search_cab_1 extends Activity {
	static ImageView img;
	 ProgressDialog pDialog;
	static int rotate=0;
	private Handler handler = new Handler();
	private boolean isBusy = false;//this flag to indicate whether your async task completed or not
	private boolean stop = false;
	TextView bid,sd;
	public static String driver="";
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_search_cab_1);
		img = (ImageView) findViewById(R.id.imageView1);
		
		bid = (TextView) findViewById(R.id.textView3);
		sd = (TextView) findViewById(R.id.textView4);
		
		bid.setText("Booking ID : "+user_search_cab.cid);
		sd.setText(user_search_cab.user_source+" - "+user_search_cab.user_destination);
	
//            pDialog = new ProgressDialog(user_search_cab_1.this);
//            pDialog.setMessage("Requesting...");
//            pDialog.setIndeterminate(false);
//            pDialog.setCancelable(true);
//            pDialog.addContentView(img, new RelativeLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT));
//            pDialog.show();
		   

		    startHandler();
		
	 
		/*
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
 	public void startHandler()
 	{
 		 RotateAnimation rotate = new RotateAnimation(
		            0, 359,
		            Animation.RELATIVE_TO_SELF, 0.5f,
		            Animation.RELATIVE_TO_SELF, 0.5f
		    );
		    rotate.setDuration(2500);
		    rotate.setRepeatCount(Animation.INFINITE);
		    img.startAnimation(rotate);
 	    handler.postDelayed(new Runnable()
 	    {

 	        @Override
 	        public void run()
 	        {
 	            if(!isBusy) callAysncTask();

 	            if(!stop) startHandler();
 	        }
 	    }, 10000);
 	   img.setVisibility(View.INVISIBLE);
 	}
 	private void callAysncTask()
 	{
 	    //TODO
 		 new reg().execute();	
 	}
 	  @Override
 	   public void onBackPressed() {
 	      Toast.makeText(getApplicationContext(), "Still Loading.\n\nWait.....", Toast.LENGTH_SHORT).show();
 	   }
    public void rotate_Clockwise(View view) {
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 180f, 0f);
//        rotate.setRepeatCount(10);
        rotate.setDuration(500);
        rotate.start();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	boolean doubleBackToExitPressedOnce = false;

//	@Override
//	public void onBackPressed() {
//	    if (doubleBackToExitPressedOnce) {
//	        super.onBackPressed();
//	        return;
//	    }
//	        
//	    this.doubleBackToExitPressedOnce = true;
//	    Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//	        
//	    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//	        
//	        @Override
//	        public void run() {
//	            doubleBackToExitPressedOnce=false;                       
//	        }
//	    }, 2000);
//	} 
	
	public class reg extends AsyncTask<String, String, String> {

	    
//		 String lname=useremail.getText().toString();
//		String	lpass=password.getText().toString();

		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
//		            pDialog = new ProgressDialog(user_search_cab_1.this);
//		            pDialog.setMessage("Requesting...");
//		            pDialog.setIndeterminate(false);
//		            pDialog.setCancelable(true);
//		            pDialog.show();
		        }

		        

		        protected String doInBackground(String... args) {

		            String txt = "";
		            


		            try {
		           	 
		            	
		                String ur = "http://"+MainActivity.sip+"/user_search_cab_1.php?"+ "id=" + user_search_cab.cid;
		 
		               
		               
		                URL url = new URL(ur);
		                Log.i("URL", ""+url);
		                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		                DataInputStream dis = new DataInputStream(uc.getInputStream());
		                String t = "";

		                while ((t = dis.readLine()) != null) {
		                    txt += t;
		                }
		                Log.i("Read", txt);
		              //  m=txt;
		                dis.close();
		                               
		            } catch (Exception e) {
		                Log.i("Login Ex", e.getMessage());
		            }
		            return txt;
		        }
		        protected void onPostExecute(String file_url) {
		      	  Log.i("file_url", file_url);
		      	  
		      	  if((file_url.length())>0)
		      		  {
		      		driver=file_url.toString().trim();
		      		  Toast.makeText(getApplicationContext(), ""+file_url, Toast.LENGTH_LONG).show();
		      		  finish();
		      		// pDialog.dismiss();
		      		stop=true;
		      		isBusy=true;
		      		Intent in = new Intent(getApplicationContext(), user_search_cab_2.class);
			         startActivity(in);	
		      		  }
			           
		               
		              
			              
		         
		      }
		  
		}
}
