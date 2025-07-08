package com.example.cab_booking_driver;
 
 
 
 
import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

 
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class driver_new_request_1 extends Activity {
	 ProgressDialog pd;
	 ProgressDialog pDialog;
	 TextView txt;
	 Button vmap,complet;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.driver_new_request_1);
		txt = (TextView)findViewById(R.id.textView2);
		
		vmap = (Button)findViewById(R.id.button1);
		complet = (Button)findViewById(R.id.button2);
		   
        pd = new ProgressDialog(this);
        pd.setMessage("Loading please wait");
        pd.setCancelable(false);
		 new userlogin1().execute();
		 
	  
		 vmap.setOnClickListener(new OnClickListener() 
	        {

				@Override
				public void onClick(View arg0) {
				 	 
				  Intent i = new Intent(driver_new_request_1.this,mapview1.class);
			    	 

				   startActivity(i);
			 
					
				}
	        }); 
		 complet.setOnClickListener(new OnClickListener() 
	        {

				@Override
				public void onClick(View arg0) {
				 	 
					  new userlogin().execute();
			 
					
				}
	        }); 
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
	public class userlogin1 extends AsyncTask<String, String, String> {

	    

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           
        }

        

        protected String doInBackground(String... args) {

            String txt = "";
            


            try {
           	 
            	
                String ur = "http://"+MainActivity.sip+"/driver_new_request_1_view.php?"+ "id=" + driver_new_request.id;
 
               
               
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
      	  String d[]=file_url.split("#");
      	  
      	 String msg="Name:"+d[1]
    	    		+"\nLatitude:"+d[2]
    	    		+"\nLongitude:"+d[3]
    	    		+"\nSource:"+d[4]
    	    		+"\nDestination:"+d[5]
    	    		+"\nAmount:"+d[12]
    	    		+"\nVehicle No:"+d[11] 
    	    		;
      	 txt.setText(msg);
        	//  mobile=file_url.trim();
        	//  Intent in = new Intent(getApplicationContext(), user_home.class);
		       //   startActivity(in);
        //  SmsManager smsManager1 = SmsManager.getDefault();
        //   smsManager1.sendTextMessage(login.mobile.toString().trim(), null, msg, null, null);
          
      }
  
}     







	public class userlogin extends AsyncTask<String, String, String> {
	    @Override
	    protected void onPreExecute() {
	        super.onPreExecute();
	        pDialog = new ProgressDialog(driver_new_request_1.this);
	        pDialog.setMessage("Connecting...");
	        pDialog.setIndeterminate(false);
	        pDialog.setCancelable(true);
	        pDialog.show();
	    }

	    

	    protected String doInBackground(String... args) {

	        String txt = "";
	        


	        try {
	       	 
	        	
	            String ur = "http://"+MainActivity.sip+"/driver_complete_update.php?id="+driver_new_request.id;

	           
	           
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
	            pDialog.dismiss();
	        	finish();
	         // Intent in = new Intent(getApplicationContext(), driver_new_request_1.class);
	      // startActivity(in);
	      
	      
	        
	     
	  }

	}		 


}

