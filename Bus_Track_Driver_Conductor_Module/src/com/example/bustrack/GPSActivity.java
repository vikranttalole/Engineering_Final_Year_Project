package com.example.bustrack;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GPSActivity extends Activity {
	String location, latlong;
	String city;
	String uid, busno;
	Button stopButton, emergencyButton;
	List<Address> addresses;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		uid = getIntent().getStringExtra("id");
		busno = getIntent().getStringExtra("busid");
		stopButton = (Button) findViewById(R.id.stopButton);
		emergencyButton = (Button) findViewById(R.id.emergencyButton);

		// updating the location in span of time
		final Handler handler = new Handler();
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				try {
					// do your code here
					// also call the same runnable
					getGPSLocation(uid, busno);
					handler.postDelayed(this, 100);
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					// also call the same runnable
					handler.postDelayed(this, 100);
				}
			}
		};
		handler.postDelayed(runnable, 1000);

		// to stop location updation

		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HashMap<String, String> pm = new HashMap<String, String>();
				pm.put("uid", uid);
				pm.put("busid", busno);
				pm.put("ulocation", city);
				String returnValue = Network.connect("http://" + Network.IP
						+ "/removeBus", pm);

				handler.removeCallbacks(runnable);
				
				Intent in=new Intent(getApplicationContext(),LoginActivity.class);
				startActivity(in);

			}
		});
		// Emergency message sending

        Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
		emergencyButton.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
		                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();


						HashMap<String, String> pm = new HashMap<String, String>();
						pm.put("uid", uid);
						pm.put("busid", busno);
						pm.put("ulocation", location);
						 
//		                String id = Network.connect("http://" + Network.IP
//		                        + "/sendSms.php", pm);
		                String phoneNumber = "8766872025";
		                String message = "Hello Admin, My location is :- http://maps.google.com/maps?q=loc:"+location+" Help me!!";
		                Toast.makeText(getApplicationContext(), "Clicked11", Toast.LENGTH_LONG).show();
		                sendSms(phoneNumber, message);
		                // Get the default instance of SmsManager
//		                SmsManager smsManager = SmsManager.getDefault();

		                // Create a PendingIntent
//		                PendingIntent sentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent("SMS_SENT"), 0);

		                // Send the SMS
//		                smsManager.sendTextMessage(phoneNumber, null, message, sentIntent, null);

		                // Display a toast to indicate that the SMS has been sent
		                Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_LONG).show();
						String returnValue = Network.connect("http://" + Network.IP
								+ "/EmergencyMsg", pm);
						returnValue = returnValue.trim();

						if (returnValue.equals("0")) {
							Toast.makeText(getApplicationContext(), " it takes time ",
									Toast.LENGTH_SHORT).show();
						} else if (!returnValue.equals("0")) {

							Toast.makeText(getApplicationContext(),
									"send sms '" + returnValue + "' ",
									Toast.LENGTH_SHORT).show();

						}

					}
				});

	}
	private void sendSms(String phoneNumber, String message) {
		   Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse( "sms:" + phoneNumber ) ); 
		   intent.putExtra( "sms_body", message ); 
		   startActivity(intent);
		}
	public void getGPSLocation(String uid1, String busno1) throws IOException {

		

		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		Location loc = lm
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

		LocationListener ll = new mylocationlistener();
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 10,
				ll);
		if (loc != null) {
			double lat = loc.getLatitude();
			double lng = loc.getLongitude();

			location = lat + "," + lng;

			Geocoder geocoder = new Geocoder(this, Locale.getDefault());
			addresses = geocoder.getFromLocation(lat, lng, 1);
			city = addresses.get(0).getAddressLine(1);

			Toast.makeText(getApplicationContext(), " city name" + city + "",
					Toast.LENGTH_SHORT).show();

			// String cityName = addresses.get(0).getAddressLine(0);
		}

		Toast.makeText(getApplicationContext(), "you r at '" + location + "'",
				Toast.LENGTH_LONG).show();

		Toast.makeText(getApplicationContext(), " location " + location + " ",
				Toast.LENGTH_SHORT).show();
		HashMap<String, String> pm = new HashMap<String, String>();
		pm.put("uid", uid1);
		pm.put("busid", busno1);
		pm.put("ulocation", location);
		String rs = Network.connect("http://" + Network.IP + "/TrackBus", pm);
		rs = rs.trim();

		if (rs.equals("0")) {
			Toast.makeText(getApplicationContext(), " it takes time ",
					Toast.LENGTH_SHORT).show();
		} else if (!rs.equals("0")) {

			Toast.makeText(getApplicationContext(), " bus track '" + rs + "' ",
					Toast.LENGTH_SHORT).show();

		}
	}

	private class mylocationlistener implements LocationListener {
		@Override
		public void onLocationChanged(Location location) {

			if (location != null) {
				Log.d("LOCATION CHANGED", location.getLatitude() + "");
				Log.d("LOCATION CHANGED", location.getLongitude() + "");
				String str = "\n CurrentLocation: " + "\n Latitude: "
						+ location.getLatitude() + "\n Longitude: "
						+ location.getLongitude();

				String locationStr = location.getLatitude() + ","
						+ location.getLongitude();

				// // Toast.makeText(getApplicationContext(),
				// // "location is '"+str+"'",Toast.LENGTH_LONG).show();
				// Toast.makeText(getApplicationContext(),
				// "location is '" + locationStr + "'", Toast.LENGTH_LONG)
				// .show();
			}

		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

	}

}
