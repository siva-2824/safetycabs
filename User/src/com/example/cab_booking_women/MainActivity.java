package com.example.cab_booking_women;
 
 
import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

 
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	public static String sip="";
	ProgressDialog pDialog;
	EditText name;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (EditText) findViewById(R.id.editText1);
		name.setText("192.168.1.2");
		//address.setHint("Designation");
		btn = (Button) findViewById(R.id.button1);
		 btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String hname= name.getText().toString();
                 if(hname.isEmpty())
                 {
                 	
                 	Toast toast = Toast.makeText(getApplicationContext(), "Enter Ip Address", Toast.LENGTH_LONG);
                 	toast.setGravity(Gravity.CENTER, 0, 0);
                 	toast.show();
                 }
                 else
                 {
                 	sip=hname+"/android_women_safety_cab_booking";  
                 	//  Intent in = new Intent(getApplicationContext(), home.class);
    	              //  Intent in = new Intent(getApplicationContext(), user_location_track_select1.class);
    	         //  startActivity(in);
                   new userlogin().execute();
                 }	                       
             }
         });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 public class userlogin extends AsyncTask<String, String, String> {
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            pDialog = new ProgressDialog(MainActivity.this);
	            pDialog.setMessage("Connecting...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }

	        

	        protected String doInBackground(String... args) {

	            String txt = "";
	            


	            try {
	           	 
	            	
	                String ur = "http://"+sip+"/login.php";
	 
	               
	               
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
	          if ((file_url.trim().equals("202504"))||file_url.trim().equals("202505")||file_url.trim().equals("202506")||file_url.trim().equals("202507")||file_url.trim().equals("202508")) {

	        	 

	               	Toast.makeText(getApplicationContext(), "Connected Successfully", Toast.LENGTH_LONG).show();
	               
	            	finish();
	                 Intent in = new Intent(getApplicationContext(), login.class);
	              //  Intent in = new Intent(getApplicationContext(), user_location_track_select1.class);
	           startActivity(in);
	          
	          }
	           else if(file_url.trim().equals("failed")) {
	              Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
	          }
	          else
	          { Toast.makeText(getApplicationContext(), "Connection Failed - Check Server..", Toast.LENGTH_LONG).show();}

	          pDialog.dismiss();
	      }
	  
	}  
}
