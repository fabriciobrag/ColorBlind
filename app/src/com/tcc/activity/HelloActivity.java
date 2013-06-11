package com.tcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tcc.app.SyncContact;

/**
 * Tela incial do aplicativo.
 * 
 * @authors Fabrício e Manoel
 * 
 */
public class HelloActivity extends MenuOptions {


	private Button startButton;
	
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//sherlock theme
        setTheme(R.style.Theme_Sherlock); 
        
		super.onCreate(savedInstanceState);

		setContentView(R.layout.hello_activity);

		startButton = (Button) findViewById(R.id.start_test);
		//bind listeners
		listeners();
		//syncronize Contatcs
		new AsyncContact(this).execute();		
				
	}
	

	/**
	 * Conjunto de metodos listeners
	 */
	private void listeners() {
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				mainActivity();
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
	
	
	
}

class AsyncContact extends AsyncTask <Void, Void, Void> {
	   
	private Context mContext;
	
	public AsyncContact (Context cntx) {
		this.mContext = cntx;
	}
   	
   protected Void doInBackground(Void... cn) {
//	   Log.i(ManagerTest.APP_NAME, "IN BACKGROUND" );
	   
	   SyncContact sync = new SyncContact(mContext);
	   sync.synchronize();
	  
		
	   return null;
   }
   
   
}

