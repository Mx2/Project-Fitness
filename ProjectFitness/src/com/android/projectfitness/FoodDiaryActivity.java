package com.android.projectfitness;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
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


			String url = "http://fitatuva.appspot.com";
			ConnectivityManager connMgr = (ConnectivityManager)
					getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {
				new postTask().execute(url);
				new getRequestTask().execute(url);
				System.out.println("Yay1");
			} else {
				System.out.println("No connection. :(");

			}
		};

	};

	private class postTask extends AsyncTask {
		
		String output = "test, 100";

		//doInBackground does stuff in background thread
		protected Object doInBackground(Object... objects) {
			String myurl = (String) objects[0];
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(myurl);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("content", output));
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				client.execute(httpPost);
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("Yay2");
			try {
				HttpResponse response = client.execute(httpPost);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				System.out.println("Yay3");
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					System.out.println("Yay4");
					String line;
					//List<String> diary = new ArrayList<String>();
					while ((line = reader.readLine()) != null) {
						builder.append(line);
						//diary.add(line);
						System.out.println(line);
					}
				} else {
					System.out.println("Failed to download");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return builder.toString();
		}
	}


	private class getRequestTask extends AsyncTask {

		//doInBackground does stuff in background thread
		protected Object doInBackground(Object... objects) {
			String myurl = (String) objects[0];
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(myurl);
			System.out.println("Yay5");
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				System.out.println("Yay6");
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					System.out.println("Yay7");
					String line;
					List<String> diary = new ArrayList<String>();
					while ((line = reader.readLine()) != null) {
						builder.append(line);
						diary.add(line);
						System.out.println(line);
					}
				} else {
					System.out.println("Failed to download");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return builder.toString();
		}
	}



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


};

