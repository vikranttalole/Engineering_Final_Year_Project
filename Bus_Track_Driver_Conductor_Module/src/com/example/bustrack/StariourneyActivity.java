package com.example.bustrack;

import java.util.ArrayList;
import java.util.List;



import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class StariourneyActivity extends Activity {
	Spinner busnospin, busrout, source, destination;
	Button srtbtn,btn;
	Context cn;
	
	ArrayAdapter<CharSequence> bn;
	ArrayAdapter<CharSequence> br;
	ArrayAdapter<CharSequence> sr;
	ArrayAdapter<CharSequence> dt;
	String[] Busno = { "101", "1", "101", "101", "101" };
	String[] rout = { "Nashik Road", "Pathardi", "Ozer", "Satpur"};
	String[] src = { "NSK", "PTD", "OZ", "SP"};
	String[] dst = { "Nashik Road", "Pathardi", "Ozer", "Satpur"};
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stariourney);
		busnospin = (Spinner) findViewById(R.id.busnospin);
		busrout = (Spinner) findViewById(R.id.busrout);
		source = (Spinner) findViewById(R.id.source);
		destination = (Spinner) findViewById(R.id.destination);
		srtbtn= (Button) findViewById(R.id.srtbtn);
	    btn= (Button) findViewById(R.id.srtbtn);
	        
		
		
		bn = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, Busno);
		bn.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		busnospin.setAdapter( bn);
		
		br = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, rout);
		br.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		busrout.setAdapter(br);
		
		sr = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, src);
		 sr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 source.setAdapter( sr);
		
		dt = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_spinner_item, dst);
		dt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		destination.setAdapter(dt);
		
		 btn.setOnClickListener(new OnClickListener() 
		    {
			
				public void onClick(View v) {
					
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), "Your journey Start", Toast.LENGTH_SHORT).show();
					finish();
					
					 }
				
				
			});
		
		

	}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stariourney, menu);
		return true;
	}

}
