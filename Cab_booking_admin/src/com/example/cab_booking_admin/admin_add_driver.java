package com.example.cab_booking_admin;

 
import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
 

import android.os.AsyncTask;
import android.os.Bundle;
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

public class admin_add_driver extends Activity {
	EditText name,contact,email,address,license_no,vehicle_no,vehicle_name,no_of_seat,amount,password;
	Button btn;
	 ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_add_driver);
		
		name = (EditText) findViewById(R.id.editText1);
		contact = (EditText) findViewById(R.id.editText2);
		email = (EditText) findViewById(R.id.editText3);
		address = (EditText) findViewById(R.id.editText5);
		license_no = (EditText) findViewById(R.id.editText4lic);
		vehicle_no = (EditText) findViewById(R.id.editText4bnum);
		vehicle_name = (EditText) findViewById(R.id.editText4);
		no_of_seat = (EditText) findViewById(R.id.editText5333);
		amount = (EditText) findViewById(R.id.editText5amk);
		password = (EditText) findViewById(R.id.isb);
		
		btn = (Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View arg0) {	
				String name1=name.getText().toString().trim();
				String contact1=contact.getText().toString().trim();
				String email1=email.getText().toString().trim();
				String address1=address.getText().toString().trim();
				String license_no1=license_no.getText().toString().trim();
				String vehicle_name1=vehicle_name.getText().toString().trim();
				String vehicle_no1=vehicle_no.getText().toString().trim();
				String no_of_seat1=no_of_seat.getText().toString().trim();
				String amount1=amount.getText().toString().trim();
				String password1=password.getText().toString().trim();

				if(name1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_LONG).show();	
				}
				else if(contact1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Contact", Toast.LENGTH_LONG).show();	
				}
				else if(email1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_LONG).show();	
				}
				else if(address1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Addressd", Toast.LENGTH_LONG).show();	
				}
				else if(license_no1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Lincense No", Toast.LENGTH_LONG).show();	
				}
				else if(vehicle_name1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Vehicle Name", Toast.LENGTH_LONG).show();	
				}
				else if(vehicle_no1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Vehicle No", Toast.LENGTH_LONG).show();	
				}
				else if(no_of_seat1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter No of Seats", Toast.LENGTH_LONG).show();	
				}
				else if(amount1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Amount", Toast.LENGTH_LONG).show();	
				}
				else if(password1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_LONG).show();	
				}
				
				else
				{
					new reg().execute();	
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
	 public class reg extends AsyncTask<String, String, String> {

		 	String name1=name.getText().toString().trim();
			String contact1=contact.getText().toString().trim();
			String email1=email.getText().toString().trim();
			String address1=address.getText().toString().trim();
			String license_no1=license_no.getText().toString().trim();
			String vehicle_name1=vehicle_name.getText().toString().trim();
			String vehicle_no1=vehicle_no.getText().toString().trim();
			String no_of_seat1=no_of_seat.getText().toString().trim();
			String amount1=amount.getText().toString().trim();
			String password1=password.getText().toString().trim();
			
	        @Override
	        protected void onPreExecute() {
	        	// Toast.makeText(getApplicationContext(), "process", Toast.LENGTH_LONG).show();
	            super.onPreExecute();
	            pDialog = new ProgressDialog(admin_add_driver.this);
	            pDialog.setMessage("Requesting...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }
	        protected String doInBackground(String... args) {
	            String txt = "";
	            try {
	                String ur = "http://"+MainActivity.sip+"/admin_add_driver.php?"
	                + "name=" +  URLEncoder.encode(name1, "UTF-8") 
	                + "&contact=" + URLEncoder.encode(contact1, "UTF-8") 
	                + "&email=" + URLEncoder.encode(email1, "UTF-8")  
	                + "&address=" + URLEncoder.encode(address1, "UTF-8") 
	                +"&license_no="+ URLEncoder.encode(license_no1, "UTF-8") 
	                +"&vehicle_name="+ URLEncoder.encode(vehicle_name1, "UTF-8") 
	                +"&vehicle_no="+ URLEncoder.encode(vehicle_no1, "UTF-8") 
	                +"&no_of_seat="+ URLEncoder.encode(no_of_seat1, "UTF-8") 
	                +"&amount="+ URLEncoder.encode(amount1, "UTF-8") 
	                +"&password="+ URLEncoder.encode(password1, "UTF-8") 
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
	      	  String tmp=file_url;
	      	  
	          if (file_url.trim().equals("success")) {

	             
	          	Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
	          	
	             // Intent in = new Intent(getApplicationContext(), login.class);
	            //  startActivity(in);
	          	finish();
	          
	          }
	          	//  muser =uid.getText().toString();
	          

	           else if(file_url.trim().equals("failed")) {
	        	   
	              Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
	          }
	          else
	          { 
	        	  Toast.makeText(getApplicationContext(), "Please Check Login...!", Toast.LENGTH_LONG).show();}

	          pDialog.dismiss();
	      }
	  
	}
}
