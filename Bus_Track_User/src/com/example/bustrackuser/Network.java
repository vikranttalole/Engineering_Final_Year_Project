package com.example.bustrackuser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.os.StrictMode;

public class Network {
	protected static final String IP = "192.168.212.199:8084/BustrackingAdmin";
	static String flag=null;
	@SuppressLint("NewApi")
	public static String connect(String url, HashMap<String, String> param) {
		// TODO Auto-generated method stub
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		try {
			Iterator it = param.entrySet().iterator();
			String paramStr="";
//			String paramStr2="";
			while (it.hasNext()){
				Map.Entry pairs = (Map.Entry)it.next();
				paramStr+= "&"+pairs.getKey()+"="+URLEncoder.encode(pairs.getValue()+"","UTF-8");
			}
			paramStr=paramStr.replaceFirst("&","");
			System.out.println("URL:"+url+"?"+paramStr);
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url+"?"+paramStr);
			HttpResponse response;
			response = httpclient.execute(httpGet);
			BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {                    
				sb.append(line + NL);
			}
			in.close();
			System.out.println("response:"+sb.toString());
//			flag=sb.toString();
			return sb.toString();

		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("err:"+e.getMessage());
			e.printStackTrace();
		} 
		return flag;
	}
}
