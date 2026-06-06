package com.example.bustrackuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BcsActivity extends Activity {
	ListView ls;
	TextView tv;
	List<String> li=new ArrayList<String>();
	String[] bs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bcs);
		

		tv = (TextView) findViewById(R.id.text1);
		ls = (ListView) findViewById(R.id.listView1);

        HashMap<String, String> pm = new HashMap<String, String>();
		pm.put("user", "uv");
		
		String rs = Network.connect("http://" + Network.IP
				+ "/Bcs", pm);
		Toast.makeText(getApplicationContext(), " toast "+rs+"",
				Toast.LENGTH_SHORT).show();
		System.out.println(rs);
		rs = rs.trim();
		

		if (rs.equals("0")) {
			Toast.makeText(getApplicationContext(), " failed "+rs+"",
					Toast.LENGTH_SHORT).show();

		} else if (!rs.equals("0")) {
			bs=rs.split("~");
			for (int i = 0; i < bs.length; i++) 
				{
				li.add(bs[i]);
	}
}

		ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, li);
		ls.setAdapter(adp);

	}
		
		
		
		
	

	

}
