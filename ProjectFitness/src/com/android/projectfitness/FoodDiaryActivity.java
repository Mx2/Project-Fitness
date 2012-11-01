package com.android.projectfitness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FoodDiaryActivity extends Activity {
	
	Button submit = null;
	EditText meal = null;
	EditText calories = null;
	
	private OnClickListener submitListener = new OnClickListener() {
		public void onClick(View v) {
			
			//concatenate string "meal, calories"
			String mealstr = meal.getText().toString(); 
			String caloriestr = calories.getText().toString();
			String m = mealstr.concat(", ");
			String output = m.concat(caloriestr);
			
			//send output to url
			
	        // make sure the fields are not empty
	        if (output.length()>1) {
				  
	        	HttpClient httpclient = new DefaultHttpClient();
		        HttpPost httppost = new HttpPost("http://fitatuva.appspot.com/");
			try {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				nameValuePairs.add(new BasicNameValuePair("context", output));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				httpclient.execute(httppost); //how to "submit" this text?
				meal.setText(""); // clear text box
				calories.setText("");
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
			} catch (IOException e) {
				// TODO Auto-generated catch block
			}
	
			}
			else
			{
				// display message if text fields are empty
				Toast.makeText(getBaseContext(),"All fields are required",Toast.LENGTH_SHORT).show();
			}
		}
	};
				    
			
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_diary);
        
        submit = (Button) findViewById(R.id.buttond);
        meal = (EditText) findViewById(R.id.editText1);
        calories = (EditText) findViewById(R.id.editText2);
        

       submit.setOnClickListener(submitListener);
       
       
    }
}