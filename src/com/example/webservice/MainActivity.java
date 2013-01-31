package com.example.webservice;



import java.util.ArrayList;

import javax.xml.datatype.Duration;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        
        adapter.setDropDownViewResource(R.layout.spinner_drop_down_form);
                
        spinner.setAdapter(adapter);
        
        //new LongOperation().execute("");
   }	
    
    private class LongOperation extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			JsonParser parser = new JsonParser();
	        JSONObject jsonResponse = parser.getJSONFromUrl("http://192.168.1.107:8080/restaurants.json", new ArrayList<NameValuePair>());
	        try {
	        	Intent intent = new Intent(getApplicationContext(), List.class);
	        	intent.putExtra("name", jsonResponse.getString("name"));
	        	startActivity(intent);
				finish();
			} catch (JSONException e) {
				Log.e("welcome", "adsf");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        

			return null;
		}
    	
    }
    

  
}

