package com.example.bustrackuser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BusDetailsActivity extends Activity {
	Button viewRoute, busesAvailable, Busno, youAt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus_details);
		viewRoute = (Button) findViewById(R.id.button1);
		busesAvailable = (Button) findViewById(R.id.button2);
		Busno = (Button) findViewById(R.id.button3);

		viewRoute.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(BusDetailsActivity.this,
						ViewRouteActivity.class);
				startActivity(i);

			}
		});

		busesAvailable.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i2 = new Intent(BusDetailsActivity.this,
						Bus_AviActivity.class);
				startActivity(i2);
			}
		});
		Busno.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i3 = new Intent(BusDetailsActivity.this,
						BusNoActivity.class);
				startActivity(i3);

			}
		});

	}

}
