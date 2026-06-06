package com.example.bustrackuser;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	// Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    TextView welcome;
    ImageView  bus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		welcome=(TextView)findViewById(R.id.welcome);
		bus=(ImageView)findViewById(R.id.bus);
		 new Handler().postDelayed(new Runnable() {
			 
	            /*
	             * Showing splash screen with a timer. This will be useful when you
	             * want to show case your app logo / company
	             */
	 
	            @Override
	            public void run() {
	                // This method will be executed once the timer is over
	                // Start your app main activity
	                Intent i = new Intent(MainActivity.this, BusDetailsActivity.class);
	                startActivity(i);
	 
	                // close this activity
	                finish();
	            }
	        }, SPLASH_TIME_OUT);
	    
		
	}

	
}
