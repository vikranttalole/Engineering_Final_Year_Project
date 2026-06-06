package com.example.bustrackuser;

import java.util.HashMap;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BusNoActivity extends Activity {
	EditText bno;
	TextView bnum,src,des,tm,presentLocation;
	Button search;
	String[] sep;
	String[] sep1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_no);
		
		bno=(EditText)findViewById(R.id.bno);
		src=(TextView)findViewById(R.id.src);
		des=(TextView)findViewById(R.id.des);
		tm=(TextView)findViewById(R.id.tm);
		bnum=(TextView)findViewById(R.id.bnum);
		search=(Button)findViewById(R.id.button1);
		presentLocation=(TextView)findViewById(R.id.youAt);
		
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				HashMap<String, String> param = new HashMap<String, String>();
				param.put("bid", bno.getText().toString());

				String id = Network.connect("http://" + Network.IP + "/BNumber",
						param);

				id = id.trim();
				

				if (id.equals("0")) {
					Toast.makeText(getApplicationContext(), " Login Failed ",
							Toast.LENGTH_SHORT).show();
				} else if (!id.equals("0")) {
				 sep = id.split(",");

					Toast.makeText(getApplicationContext(),
							" bus details '" + id + "' ", Toast.LENGTH_SHORT).show();
					
					bnum.setText("BUS NUMBER: " + sep[0].toString());
					src.setText("FROM: " + sep[1].toString());
					des.setText("DESTINATION: " + sep[2].toString());
					tm.setText("ARRIVAL TIME: " + sep[3].toString());

				}
				
				
				HashMap<String, String> loc = new HashMap<String, String>();
				loc.put("bid", sep[0].toString());

				String rs = Network.connect("http://" + Network.IP + "/UserLocation",
						loc);

				rs = rs.trim();
				

				if (rs.equals("0")) {
					Toast.makeText(getApplicationContext(), " Login Failed ",
							Toast.LENGTH_SHORT).show();
				} else if (!rs.equals("0")) {
					 sep1 = rs.split("~");
					
					presentLocation.setText(sep1[0].toString());
					
			}
				
			}
			
		});
		
		
		presentLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String strUri = "http://maps.google.com/maps?q=loc:" +presentLocation.getText().toString();
				  Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
	                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
	                startActivity(intent);
			
			}
		});

		
	}

	
}
