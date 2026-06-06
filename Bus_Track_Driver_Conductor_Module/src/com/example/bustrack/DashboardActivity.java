package com.example.bustrack;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends Activity {
	public Button Startjbtn, Stopjbtn;
	String uid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		uid = getIntent().getStringExtra("id");
		Startjbtn = (Button) findViewById(R.id.Startjbtn);
		Stopjbtn = (Button) findViewById(R.id.Stopjbtn);
		Stopjbtn.setVisibility(View.INVISIBLE);
		
		Startjbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(DashboardActivity.this,
						StartjActivity.class);
				intent.putExtra("id",uid );
				startActivity(intent);
			//Startjbtn.setVisibility(View.INVISIBLE);
			//Stopjbtn.setVisibility(View.VISIBLE);
			
			}
		});
		Stopjbtn.setOnClickListener(new OnClickListener() 
	    {
		
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Your journey Stop", Toast.LENGTH_SHORT).show();
				//Startjbtn.setVisibility(View.VISIBLE);
				//Stopjbtn.setVisibility(View.INVISIBLE);
				 }
			
			
		});
		
	}

	

}







