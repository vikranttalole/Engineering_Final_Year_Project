package com.example.bustrackuser;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ViewRouteActivity extends Activity {
	Button cton,ctos,ctom,ctoo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_route);
		cton=(Button)findViewById(R.id.button1);
		ctos=(Button)findViewById(R.id.button2);
		ctom=(Button)findViewById(R.id.button3);
		ctoo=(Button)findViewById(R.id.button4);
		
		cton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i1=new Intent(ViewRouteActivity.this,CtonActivity.class);
				startActivity(i1);
			}
		});
		
		ctos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i2=new Intent(ViewRouteActivity.this,CtoSActivity.class);
				startActivity(i2);
				
			}
		});
		
		ctom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i3=new Intent(ViewRouteActivity.this,CtoMActivity.class);
				startActivity(i3);
				
			}
		});
		
		ctoo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i4=new Intent(ViewRouteActivity.this,CtoOActivity.class);
				startActivity(i4);
			}
		});
		
	}

	

}
