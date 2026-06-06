package com.example.bustrack;


import java.util.HashMap;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	EditText drivern, driverp;
	Button driverlbtn, driverrbtn;
	String uid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		drivern = (EditText) findViewById(R.id.drivern);
		driverp = (EditText) findViewById(R.id.driverp);
		driverlbtn = (Button) findViewById(R.id.driverlbtn);
		//driverrbtn = (Button) findViewById(R.id.driverrbtn);
	

		driverlbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {	
				
				
				HashMap<String, String> param = new HashMap<String, String>();
				param.put("username", drivern.getText().toString().trim());
				param.put("password", driverp.getText().toString().trim());
				String id = Network.connect("http://" + Network.IP
						+ "/Login_Driver", param);
				
				id = id.trim();
//				Toast.makeText(getApplicationContext(), " Login "+id+" ",
//						Toast.LENGTH_LONG).show();
				if (id.equals("0")) {
					Toast.makeText(getApplicationContext(), " Login Failed ",
							Toast.LENGTH_SHORT).show();
				} else {
					String[] sep=id.split(",");
					String uid=sep[0].toString();
					Toast.makeText(getApplicationContext(), " Login sucess'"+uid+"' ",
							Toast.LENGTH_SHORT).show();
					
				Intent intent = new Intent(getApplicationContext(),
							DashboardActivity.class);
				intent.putExtra("id",uid );
					Network.id = id;
					startActivity(intent);
					finish();
				}

				
				
				
				
				
			}
				});
			

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
