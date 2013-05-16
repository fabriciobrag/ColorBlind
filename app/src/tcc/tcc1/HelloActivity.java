package tcc.tcc1;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Tela incial do aplicativo.
 * 
 * @authors Fabrício e Manoel
 * 
 */
public class HelloActivity extends Activity {

	private ImageButton startImageButton, helpImagepButton;
	private DefaultHttpClient httpclient;
	private HttpPost httppost;
	private ArrayList<NameValuePair> nameValuePairs;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.hello_activity);
		carregaVariaveis();
		listeners();
		
		Log.i(ManagerTest.APP_NAME, ""+ hasActiveInternetConnection());
		
		if (hasActiveInternetConnection()) {

		
			httpclient = new DefaultHttpClient();
            httppost = new HttpPost("http://177.71.255.245/tcc/post_data.php");

            try
            {
            	DatabaseHandler db = new DatabaseHandler(this);
            	List<Contact> contacts = db.getAllContacts();
        		
        		 for (Contact cn : contacts) {
	        		 String log = "diag: "+cn.get_diag()+" , sex: " + cn.get_sex() +
	        		 " , age: " + cn.get_age();
	        		 Log.d("Name: ", log);
	        		 
	        		 
	        		
	                nameValuePairs = new ArrayList<NameValuePair>();
	                nameValuePairs.add(new BasicNameValuePair("age", cn.get_age()));
	                nameValuePairs.add(new BasicNameValuePair("result",  Integer.toString(cn.get_result())));
	                nameValuePairs.add(new BasicNameValuePair("sex", cn.get_sex()));
	                nameValuePairs.add(new BasicNameValuePair("diag", cn.get_diag()));
	                
	                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	                HttpResponse response = httpclient.execute(httppost);
	                int status = response.getStatusLine().getStatusCode();
	                
	                Log.i(ManagerTest.APP_NAME, ""+status);
	                
	                db.deleteContact(cn);
	                
	                
        		 }
        		 db.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
		}
	}
	
	private boolean hasActiveInternetConnection (){
	    if (isNetworkAvailable()) {
	        try {
	            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://177.71.255.245/tcc/post_data.php").openConnection());
	            urlc.setRequestProperty("User-Agent", "Test");
	            urlc.setRequestProperty("Connection", "close");
	            urlc.setConnectTimeout(1500); 
	            urlc.connect();
	            return (urlc.getResponseCode() == 200);
	        } catch (IOException e) {
	            Log.e(ManagerTest.APP_NAME, "Error checking internet connection", e);
	        }
	    } else {
	        Log.d(ManagerTest.APP_NAME, "No network available!");
	    }
	    return false;
	}
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager 
	          = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	private void carregaVariaveis() {
		helpImagepButton = (ImageButton) findViewById(R.id.help_hello);
		startImageButton = (ImageButton) findViewById(R.id.start_hello);
	}

	/**
	 * Conjunto de metodos listeners
	 */
	private void listeners() {
		startImageButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mainActivity();
			}
		});

		helpImagepButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				helpActivity();
			}
		});
	}

	/**
	 * Inicia a activity principal
	 */
	private void mainActivity() {
		Intent i = new Intent(this, TestActivity.class);
		startActivity(i);
	}

	/**
	 * Inicia a activity de ajuda
	 */
	private void helpActivity() {
		Intent i = new Intent(this, HelpActivity.class);
		startActivity(i);
	}
}
