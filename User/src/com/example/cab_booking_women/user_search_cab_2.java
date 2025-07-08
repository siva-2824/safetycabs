package com.example.cab_booking_women;
 

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.cab_booking_women.login.userlogin;

 
 

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class user_search_cab_2 extends Activity {
//	Button btn;
	 ProgressDialog pd;
	 GPSTracker  gps = new GPSTracker(this);
public static String police="";
	 private Handler handler = new Handler();
		private boolean isBusy = false;//this flag to indicate whether your async task completed or not
		private boolean stop = false;
	 public static String driver_name="";
	 public static String driver_contact="";
	 public static String driver_email="";
	 public static String driver_address="";
	 public static String driver_license_no="";
	 
	 public static String driver_vehicle_name="";
	 public static String driver_vehicle_no="";
	 public static String average_duration="",start_time="";
	 
	 TextView txt;
 	 public static String data="";
 	 public static int message_count=0;
 	 
	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_search_cab_2); 
		txt = (TextView)findViewById(R.id.textView2);
//		btn = (Button)findViewById(R.id.button1);
		pd = new ProgressDialog(this);
		pd.setMessage("Loading please wait");
		pd.setCancelable(false);
		new userlogin2().execute();
		new userlogin1().execute();
//		btn.setOnClickListener(new OnClickListener() 
//	        {
//
//				@Override
//				public void onClick(View arg0) {
//				 	 
//				  Intent i = new Intent(user_search_cab_2.this,mapview1.class);
//			    	 
//
//				   startActivity(i);
//			 
//					
//				}
//	        }); 
		  startHandler();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}	
	public class userlogin1 extends AsyncTask<String, String, String> 
	{
		        @Override
		        protected void onPreExecute()
		        {
		            super.onPreExecute();		           
		        }
		        protected String doInBackground(String... args) 
		        {
		            String txt = "";
		            try 
		            {
		                String ur = "http://"+MainActivity.sip+"/user_search_cab_2.php?"+ "id=" + user_search_cab.cid;
		                URL url = new URL(ur);
		                Log.i("URL", ""+url);
		                HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		                DataInputStream dis = new DataInputStream(uc.getInputStream());
		                String t = "";
		                while ((t = dis.readLine()) != null) 
		                {
		                    txt += t;
		                }
		                Log.i("Read", txt);
		                dis.close();		                              
		            } catch (Exception e) {
		                Log.i("Login Ex", e.getMessage());
		            }
		            return txt;
		        }
		        protected void onPostExecute(String file_url) {
		      	  Log.i("file_url", file_url);
		      	  String d[]=file_url.split("#");		      	  
		      	 String msg="Driver:"+d[5]
		    	    		+"\nContact:"+d[6]
		    	    		+"\nEmail:"+d[7]
		    	    		+"\nAddress:"+d[8]
		    	    		+"\nLicense:"+d[9]
		    	    		+"\nVehicle Name:"+d[10]
		    	    		+"\nVehicle No:"+d[11]
		    	    		;
			      	start_time=d[13];
			      	average_duration=d[14];			      	
		      	 	txt.setText(msg);
		      	 	SmsManager smsManager1 = SmsManager.getDefault();
		      	 	smsManager1.sendTextMessage(login.mobile.toString().trim(), null, msg, null, null);		          
		      }		  
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
		  
 	    handler.postDelayed(new Runnable()
 	    {

 	        @Override
 	        public void run()
 	        {
 	        	 gps.getLocation();
 	            if(!isBusy) callAysncTask();
 	           gps.getLocation();
 	            if(!stop) startHandler();
 	           gps.getLocation();
 	        }
 	    }, 15000);
 	    
 	}
	private void callAysncTask()
 	{
 	    //TODO
 		 new reg().execute();	
 	}
	
	public class reg extends AsyncTask<String, String, String> {

	    
//		 String lname=useremail.getText().toString();
//		String	lpass=password.getText().toString();
		 
			 
	        double  lat=gps.latitude;      
	        double  land=gps.longitude;
	        String cl1=""+lat;
	        String cl2=""+land;
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
		           	 
		            	
		                String ur = "http://"+MainActivity.sip+"/user_search_cab_2_check_status.php?"
				                + "id=" + user_search_cab.cid
				                + "&l1=" + cl1
				                + "&l2=" + cl2
		                ;
		 
		               
		               
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
		      	 Toast.makeText(getApplicationContext(), ""+file_url, Toast.LENGTH_LONG).show();
		      	  if((file_url.toString().trim().length())>0)
		      		  {
		      		 
 
		      		String msg="Emergency Alert\n"+login.uemail+"\n"+file_url+"\n"+cl1+","+cl2;
		      		
		      	 	
		      		if(message_count<3)
		      		{
		      		SmsManager smsManager1 = SmsManager.getDefault();
		      	 	smsManager1.sendTextMessage(login.mobile.toString().trim(), null, msg, null, null);	
		      	 	
		      		SmsManager smsManager2 = SmsManager.getDefault();
		      	 	smsManager2.sendTextMessage(police.toString().trim(), null, msg, null, null);
		      	  new userlogin11().execute();	
		      		}
		      		else
		      		{
		      		stop=true;
		      		isBusy=true;	
		      		}
		      		message_count++;
		      		  }
			           
		               
		              
			              
		         
		      }
		  
		}
	public class userlogin2 extends AsyncTask<String, String, String> {

		
		 
	      double  lat=gps.latitude;      
	      double  land=gps.longitude;
	@Override
	protected void onPreExecute() {
	super.onPreExecute();

	}



	protected String doInBackground(String... args) {

	String txt = "";



	try {


	String ur = "http://"+MainActivity.sip+"/get_police_number.php?"+ "l1=" + lat + "&pword=" +land;



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

	police=file_url.toString().trim();
	 

	}

	} 
	public class userlogin11 extends AsyncTask<String, String, String> {

	    
//		 String lname=useremail.getText().toString();
//		String	lpass=password.getText().toString();

		        @Override
		        protected void onPreExecute() {
		            super.onPreExecute();
		           
		        }

		        

		        protected String doInBackground(String... args) {

		            String txt = "";
		            


		            try {
		           	 
		            	
		                String ur = "http://"+MainActivity.sip+"/user_search_cab_2_update_police.php?"+ "id=" + user_search_cab.cid + "&police=" +police;
		 
		               
		               
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
		       
		        	//  mobile=file_url.trim();
		        	 // Intent in = new Intent(getApplicationContext(), user_home.class);
				       //   startActivity(in);
		          
		      }
		  
		}     
}
