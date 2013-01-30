package com.example.webservice;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JsonParser parser = new JsonParser();
        JSONObject jsonResponse = parser.getJSONFromUrl("http://192.168.1.104:8080/restaurants.json", new ArrayList<NameValuePair>());
        TextView view = (TextView) findViewById(R.id.textView1);
        view.setText("");
        try {
			view.setText(jsonResponse.getString("name"));
	        ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar1);
	        if (view.length() > 0){
	          //bar.setVisibility(View.INVISIBLE);
	        }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
