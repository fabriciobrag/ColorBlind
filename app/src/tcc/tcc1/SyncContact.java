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

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class SyncContact {

	private Context mContext;

	final String URL_POST = "http://177.71.255.245/tcc/post_data.php";

	public SyncContact(Context ctx) {
		mContext = ctx;
	}

	public  boolean hasActiveInternetConnection() {
		if (isNetworkAvailable()) {
			try {
				HttpURLConnection urlc = (HttpURLConnection) (new URL("http://google.com").openConnection());
				urlc.setRequestProperty("User-Agent", "Test");
				urlc.setRequestProperty("Connection", "close");
				urlc.setConnectTimeout(1500);
				urlc.connect();
				return (urlc.getResponseCode() == 200);
			} catch (IOException e) {
				Log.e(ManagerTest.APP_NAME,
						"Error checking internet connection", e);
			}
		} else {
			Log.d(ManagerTest.APP_NAME, "No network available!");
		}
		return false;
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	public void synchronize() {

		if (hasActiveInternetConnection()) {

			DatabaseHandler db = new DatabaseHandler(mContext);
			
			int count = db.getContactsCount();
			
			if ( count > 0 ) {
				List<Contact> contacts = db.getAllContacts();

				for (Contact cn : contacts) {
					String log = "diag: " + cn.get_diag() + " , sex: "
							+ cn.get_sex() + " , age: " + cn.get_age();
					Log.d("Unsync Contact: ", log);
					
					makePost(cn);
					db.deleteContact(cn);
				}

			}
			
			db.close();
		}
	}

	public  void makePost(Contact cn) {
		if (hasActiveInternetConnection()) {
		
			try {
				DefaultHttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost(URL_POST);
	
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				nameValuePairs.add(new BasicNameValuePair("age", cn.get_age()));
				nameValuePairs.add(new BasicNameValuePair("result", Integer
						.toString(cn.get_result())));
				nameValuePairs.add(new BasicNameValuePair("sex", cn.get_sex()));
				nameValuePairs.add(new BasicNameValuePair("diag", cn.get_diag()));
	
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response = httpclient.execute(httppost);
				int status = response.getStatusLine().getStatusCode();
	
				Log.i(ManagerTest.APP_NAME, "Request Status: " + status);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}	
	}
	
	
}
