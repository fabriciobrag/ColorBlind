package tcc.tcc1;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
public class HelloActivity extends MenuOptions {

	private ImageButton startImageButton, helpImagepButton;
	
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//sherlock theme
        setTheme(R.style.Theme_Sherlock); 
        
		Log.i(ManagerTest.APP_NAME, "CREATE : " );


		super.onCreate(savedInstanceState);

		setContentView(R.layout.hello_activity);
		//bind buttons
		loadButtons();
		//bind listeners
		listeners();
		//syncronize Contatcs
		new AsyncContact(this).execute();		
		
		
	}
	

	private void loadButtons() {
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
	public void helpActivity() {
		Intent i = new Intent(this, HelpActivity.class);
		startActivity(i);
	}

	

	/**
	 * Inicia a activity de ajuda
	 */
	public void cameraActivity() {
		Intent i = new Intent(this, CameraActivity.class);
		startActivity(i);
	}
	
	
}

class AsyncContact extends AsyncTask <Void, Void, Void> {
	   
	private Context mContext;
	
	public AsyncContact (Context cntx) {
		this.mContext = cntx;
	}
   	
   protected Void doInBackground(Void... cn) {
	   Log.i(ManagerTest.APP_NAME, "IN BACKGROUND" );
	   
	   SyncContact sync = new SyncContact(mContext);
	   sync.synchronize();
	  
		
	   return null;
   }
   
   
}
