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

public class admin_add_police extends Activity {
	EditText department,book_name,author,publish,no_of_books,book_location,isbn;
	Button btn;
	 ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin_add_police);
		
		department = (EditText) findViewById(R.id.editText1);
		book_name = (EditText) findViewById(R.id.editText2);
		author = (EditText) findViewById(R.id.editText3);
		publish = (EditText) findViewById(R.id.editText5);
		no_of_books = (EditText) findViewById(R.id.editText4);
		book_location = (EditText) findViewById(R.id.editText5);
		isbn = (EditText) findViewById(R.id.isb);
		
		btn = (Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() 
        {
			@Override
			public void onClick(View arg0) {	
				String depart1=department.getText().toString().trim();
				String scode1=book_name.getText().toString().trim();
				String sname1=author.getText().toString().trim();
				String author1=publish.getText().toString().trim();
				String cont1=no_of_books.getText().toString().trim();
				String book_location1=book_location.getText().toString().trim();
				String isbn1=isbn.getText().toString().trim();
				if(depart1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Department", Toast.LENGTH_LONG).show();	
				}
				else if(scode1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Book Name", Toast.LENGTH_LONG).show();	
				}
				else if(sname1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Author", Toast.LENGTH_LONG).show();	
				}
				else if(author1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Publish", Toast.LENGTH_LONG).show();	
				}
				else if(cont1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter No of Books", Toast.LENGTH_LONG).show();	
				}
				else if(book_location1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter Location", Toast.LENGTH_LONG).show();	
				}
				else if(isbn1.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Enter ISBN", Toast.LENGTH_LONG).show();	
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

			String depart1=department.getText().toString().trim();
			String scode1=book_name.getText().toString().trim();
			String sname1=author.getText().toString().trim();
			String author1=publish.getText().toString().trim();
			String cont1=no_of_books.getText().toString().trim();
			String book_location1=book_location.getText().toString().trim();
			String isb=isbn.getText().toString().trim();
			
	        @Override
	        protected void onPreExecute() {
	        	// Toast.makeText(getApplicationContext(), "process", Toast.LENGTH_LONG).show();
	            super.onPreExecute();
	            pDialog = new ProgressDialog(admin_add_police.this);
	            pDialog.setMessage("Requesting...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            pDialog.show();
	        }
	        protected String doInBackground(String... args) {
	            String txt = "";
	            try {
	                String ur = "http://"+MainActivity.sip+"/admin_add_police.php?"
	                + "name=" +  URLEncoder.encode(depart1, "UTF-8") 
	                + "&contact=" + URLEncoder.encode(scode1, "UTF-8") 
	                + "&email=" + URLEncoder.encode(sname1, "UTF-8")  
	                + "&address=" + URLEncoder.encode(author1, "UTF-8") 
	                +"&station="+ URLEncoder.encode(cont1, "UTF-8") 
	                +"&area="+ URLEncoder.encode(book_location1, "UTF-8") 
	                +"&password="+ URLEncoder.encode(isb, "UTF-8") 
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
