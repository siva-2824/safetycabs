package com.example.cab_booking_women;

 
 
import java.io.DataInputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

 
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class user_payment_1 extends Activity {
	 Button regbtn ;
	 ProgressDialog pDialog;
	 EditText name,contact,email;
	 public static String nam="",cont="",eml="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.user_payment_1);
		regbtn = (Button) findViewById(R.id.reg);
		name = (EditText)findViewById(R.id.name);
	    contact = (EditText)findViewById(R.id.con);
	    email = (EditText)findViewById(R.id.email);
	  
	     
		regbtn.setOnClickListener(new OnClickListener() 
	        {

				@Override
				public void onClick(View arg0) {
					nam=name.getText().toString();
				 
					cont=contact.getText().toString();
					eml=email.getText().toString();
				 
					if((nam.equals("")))
					{
						Toast.makeText(getApplicationContext(), "Enter all fileds", Toast.LENGTH_LONG).show();	
					}
					 
					else if(cont.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Enter all fileds", Toast.LENGTH_LONG).show();	
					}
					else if(eml.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Enter all fileds", Toast.LENGTH_LONG).show();	
					}
					
				 
					else
					{
						 new reg().execute();	
					}
					
					
					//Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
					 							 
					//Intent i = new Intent(Registration.this,MainActivity.class); 	 
				   	//startActivity(i);
					 // Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();
				//mEdit.setText(""+m);

					
				}
	        });
	}
	 public class reg extends AsyncTask<String, String, String> {

	        //capture values from EditText
			 
			// String accno,name1,address,gen,pass,dob;
	  		 
       
	//  String userid=u.getText().toString();
	//  String password=p.getText().toString();
		String rnam=name.getText().toString();
		 
		String	rcont=contact.getText().toString();
		String	reml=email.getText().toString();
		 
	        @Override
	        protected void onPreExecute() {
	        	// Toast.makeText(getApplicationContext(), "process", Toast.LENGTH_LONG).show();
	            super.onPreExecute();
	            pDialog = new ProgressDialog(user_payment_1.this);
	            pDialog.setMessage("Requesting " + rnam + ")...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }

	       

	        protected String doInBackground(String... args) {

	            String txt = "";
	            
	           

	            try {
	            	 String tm="";
 
	                String ur = "http://"+MainActivity.sip+"/user_payment_2.php?"
+ "id=" +URLEncoder.encode( user_payment.id , "UTF-8")  
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
	          	
	              finish();
	          
	          }
	          	//  muser =uid.getText().toString();
	          

	           else if(file_url.trim().equals("failed")) {
	              Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
	          }
	          else
	          { Toast.makeText(getApplicationContext(), file_url, Toast.LENGTH_LONG).show();
	          
	         // Toast.makeText(getApplicationContext(), "Please Check Login...!", Toast.LENGTH_LONG).show();
	          
	          }

	          pDialog.dismiss();
	      }
	  
	}
	    
}
