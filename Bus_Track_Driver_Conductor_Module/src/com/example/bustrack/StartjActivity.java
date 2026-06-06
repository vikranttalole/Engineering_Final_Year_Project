package com.example.bustrack;

import java.util.HashMap;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StartjActivity extends Activity {

	TextView bno, src, des, tm;
	String uid;
	String busno;
	
	Button startj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startj);
		bno = (TextView) findViewById(R.id.textView1);
		src = (TextView) findViewById(R.id.textView2);
		des = (TextView) findViewById(R.id.textView3);
		tm = (TextView) findViewById(R.id.textView4);
		startj = (Button) findViewById(R.id.startbtn);
		uid = getIntent().getStringExtra("id");
		

		HashMap<String, String> param = new HashMap<String, String>();
		param.put("uid", uid);

		String id = Network.connect("http://" + Network.IP + "/detaildriver",
				param);

		id = id.trim();

		if (id.equals("0")) {
			Toast.makeText(getApplicationContext(), " Login Failed ",
					Toast.LENGTH_SHORT).show();
		} else if (!id.equals("0")) {
			String[] sep = id.split(",");

			Toast.makeText(getApplicationContext(),
					" bus details '" + id + "' ", Toast.LENGTH_SHORT).show();
			busno = sep[0].toString();
			bno.setText("BUS NUMBER: " + sep[0].toString());
			src.setText("FROM: " + sep[1].toString());
			des.setText("DESTINATION: " + sep[2].toString());
			tm.setText("ARRIVAL TIME: " + sep[3].toString());

		}

		startj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent in=new Intent(StartjActivity.this,GPSActivity.class);
				in.putExtra("id",uid );
				in.putExtra("busid", busno);
				startActivity(in);
			}
				
		});

	}

}
