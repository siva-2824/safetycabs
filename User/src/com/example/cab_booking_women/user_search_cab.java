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
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class user_search_cab extends Activity 
{
	 GPSTracker  gps = new GPSTracker(this);
	 EditText rl1,rl2;
	 Button trk;
	 EditText src,dst;
	 ProgressDialog pDialog;
	 public static String cid="";
	 public static String user_source="";
	 public static String user_destination="";
//	 public static String police="";
	 EditText d1,d2;
 	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_cab_search);
		  rl1 = (EditText)findViewById(R.id.editText1);
	        rl2 = (EditText)findViewById(R.id.EditText01);
	        
	        src = (EditText)findViewById(R.id.EditText02);
	        dst = (EditText)findViewById(R.id.dstn);
	        
	        d1 = (EditText)findViewById(R.id.dd1);
	        d2 = (EditText)findViewById(R.id.dd2);
	        
	        
	        trk = (Button)findViewById(R.id.button1);
	  
	        gps.getLocation();
	 
	        double  lat=gps.latitude;      
	        double  land=gps.longitude;
	        String l1=""+lat;
	        l1=l1.toString().trim();
	        String l2=""+land;
	        l2=l2.toString().trim();	
	        
	      
	        rl1.setOnClickListener(new OnClickListener()
	        {  	      	  
	            @Override  
	            public void onClick(View arg0) 
	            {  	             
	           	 location_read();	
	            }  	             
	        });
	        
	        d2.setOnClickListener(new OnClickListener()
	        {  	      	  
	            @Override  
	            public void onClick(View arg0) 
	            {  	             
	            	 new userlogin1().execute();
	            }  	             
	        });
		
		
	 
	
	    	
	    trk.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) 
			{
				String latitude=rl1.getText().toString().trim();
				String longitude=rl2.getText().toString().trim();
				String source=src.getText().toString().trim();
				String destination=dst.getText().toString().trim();
				if(latitude.equals(""))
				{
					Toast toast = Toast.makeText(getApplicationContext(), "Enter Latitude", Toast.LENGTH_LONG);
                 	toast.setGravity(Gravity.CENTER, 0, 0);
                 	toast.show();	
				}
				else if(longitude.equals(""))
				{
					Toast toast = Toast.makeText(getApplicationContext(), "Enter Longitude", Toast.LENGTH_LONG);
                 	toast.setGravity(Gravity.CENTER, 0, 0);
                 	toast.show();
					
				}
				else if(source.equals(""))
				{
					Toast toast = Toast.makeText(getApplicationContext(), "Enter Source", Toast.LENGTH_LONG);
                 	toast.setGravity(Gravity.CENTER, 0, 0);
                 	toast.show();
					
				}
				else if(destination.equals(""))
				{
					Toast toast = Toast.makeText(getApplicationContext(), "Enter Destination", Toast.LENGTH_LONG);
                 	toast.setGravity(Gravity.CENTER, 0, 0);
                 	toast.show();
					
				}
				else
				{
					user_source=src.getText().toString().trim();
					user_destination=dst.getText().toString().trim(); 
					 new reg().execute();		
				}
	
				 
			 				
			}
        });
		/*	search_cab1.setOnClickListener(new OnClickListener() 
        {

			@Override
			public void onClick(View arg0) {
				 Intent in = new Intent(getApplicationContext(), user_search_cab.class);
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
 	void location_read()
 	  {
 		  gps.getLocation(); 		  
 	      double  lat=gps.latitude;      
 	      double  land=gps.longitude;
 	      String l1=""+lat;
 	      l1=l1.toString().trim();
 	      String l2=""+land;
 	      l2=l2.toString().trim();  
 	      rl1.setText(""+l1);
 	 	 rl2.setText(""+l2);
 	 	 
 	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*boolean doubleBackToExitPressedOnce = false;

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
	*/
	 public class reg extends AsyncTask<String, String, String> {

		 String latitude=rl1.getText().toString().trim();
			String longitude=rl2.getText().toString().trim();
			String source=src.getText().toString().trim();
			String destination=dst.getText().toString().trim(); 
			
			
			 String latitude1=d1.getText().toString().trim();
				String longitude1=d2.getText().toString().trim();
		 
			 
	        @Override
	        protected void onPreExecute() {
	        	// Toast.makeText(getApplicationContext(), "process", Toast.LENGTH_LONG).show();
	            super.onPreExecute();
	            pDialog = new ProgressDialog(user_search_cab.this);
	            pDialog.setMessage("Requesting...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }

	       

	        protected String doInBackground(String... args) {

	            String txt = "";
	            
	           

	            try {
	            	 String tm="";
	                
	                String ur = "http://"+MainActivity.sip+"/user_search_cab.php?"
+ "name=" +URLEncoder.encode( login.uemail , "UTF-8")  
+ "&latitude=" +URLEncoder.encode( latitude , "UTF-8") 
+ "&longitude=" +URLEncoder.encode( longitude , "UTF-8")
+ "&source=" +URLEncoder.encode( source , "UTF-8")
+"&destination="+URLEncoder.encode( destination , "UTF-8") 
+"&latitude1="+URLEncoder.encode( latitude1 , "UTF-8") 
+"&longitude1="+URLEncoder.encode( longitude1 , "UTF-8") 
;
	                Log.i("URL", ur);
	                URL url = new URL(ur);
	                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
	                DataInputStream dis = new DataInputStream(uc.getInputStream());
	                String t = "";

	                while ((t = dis.readLine()) != null) {
	                    txt += t;
	                }
	                //Log.i("Read", txt);
	               // m=txt;
	                dis.close();
	                               
	            } catch (Exception e) {
	                Log.i("Login Ex", e.getMessage());
	            }
	            return txt;
	        }
	        protected void onPostExecute(String file_url) {
	        	
	      	  Log.i("file_url", file_url);
	      	  cid=file_url;
	      	  try
	      	  {
	      	  int len=Integer.parseInt(cid);
	      	  if (len==0)
	      	  {
	      		  Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
	      		  
	      	  }
	      	  
	      	  else
	          {
	          	Toast.makeText(getApplicationContext(), "Request Send", Toast.LENGTH_LONG).show();
	          	finish();
	          Intent i = new Intent(user_search_cab.this,user_search_cab_1.class); 	 
			   	startActivity(i);
	          }
	      	  }
	      	  catch(Exception e)
	      	  {
	      		Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_LONG).show();
	      	  }
	      	 
//	           else if(file_url.trim().equals("failed")) 
//	           {
//	              Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
//	          }
//	          else
//	          { 
//	        	  Toast.makeText(getApplicationContext(), file_url, Toast.LENGTH_LONG).show();
//	          
//	         // Toast.makeText(getApplicationContext(), "Please Check Login...!", Toast.LENGTH_LONG).show();
//	          
//	          }

	          pDialog.dismiss();
	      }
	  
	}
	 public class userlogin1 extends AsyncTask<String, String, String> {

		 String destination=dst.getText().toString().trim(); 
			
		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		           
		        }

		        

		        protected String doInBackground(String... args) {

		            String txt = "";
		            


		            try {
		           	 
		            	
		                String ur = "http://"+MainActivity.sip+"/destination_location_get.php?"+ "pword=" +URLEncoder.encode( destination , "UTF-8") ;
		 
		               
		               
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
		       try
		       {
		        	 String data=file_url.trim().toString().trim();
		        	 String dd[]=data.split("#");
		        	 d1.setText(""+dd[0]);
		        	 d2.setText(""+dd[1]);
		       }catch(Exception e)
		       {
		    		
                	Toast toast = Toast.makeText(getApplicationContext(), "Location Not Found\nEnter Manually", Toast.LENGTH_LONG);
                	toast.setGravity(Gravity.CENTER, 0, 0);
                	toast.show();
		       }
		    //  new userlogin2().execute();
		        	  //Intent in = new Intent(getApplicationContext(), user_home.class);
				        //  startActivity(in);
		          
		      }
		  
		}     
//////////////////////////////////////////////////////////////////////////
    
}
