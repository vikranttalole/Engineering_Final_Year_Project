package com.example.bustrackuser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Bus_AviActivity extends Activity {
	Button cton,ctos,ctom,ctoo;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bus__avi);
		
		cton=(Button)findViewById(R.id.button1);
		ctos=(Button)findViewById(R.id.button2);
		ctom=(Button)findViewById(R.id.button3);
		ctoo=(Button)findViewById(R.id.button4);
		
		cton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {


				Intent i1=new Intent(Bus_AviActivity.this,BcnActivity.class);
				startActivity(i1);
				
			}
		});
		
		ctos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i1=new Intent(Bus_AviActivity.this,BcsActivity.class);
				startActivity(i1);
				
			}
		});
		
		
		ctom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i1=new Intent(Bus_AviActivity.this,BcmActivity.class);
				startActivity(i1);
				
			}
		});
		
		ctoo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i1=new Intent(Bus_AviActivity.this,BcoActivity.class);
				startActivity(i1);
				
			}
		});
		
		
		
		
		
	}

	
}
