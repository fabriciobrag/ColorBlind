package com.tcc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.actionbarsherlock.app.SherlockActivity;
import com.tcc.app.Contact;
import com.tcc.app.DatabaseHandler;
import com.tcc.app.ManagerTest;
import com.tcc.app.SyncContact;

public class GetInfoActivity extends SherlockActivity {

	private String sex, diag = "", sug = "";
	private int result, age;
	
	private RadioGroup radioGroupSex, radioGroupDiag;
	private RadioButton radioButtonSex, radioButtonDiag;
	private Button sendFeedback;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Sherlock); 

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_info);
		
		sendFeedback = (Button) findViewById(R.id.ButtonSendFeedback);
		sendFeedback.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sendInfo(v);
			}
		});
	}
  
	public void sendInfo (View button) {
		
		//age
		EditText ageField = (EditText) findViewById(R.id.EditTextAge); 
		String _age = ageField.getText().toString();
		if (_age.isEmpty()) {
			age = 0;
		} else {
			age = Integer.parseInt(_age);  
		}
		
		//sug
		EditText sugField = (EditText) findViewById(R.id.EditTextFeedbackBody);  
		sug = sugField.getText().toString();  

		//result
		result = ManagerTest.getResultPercent();
		
		//sex
		radioGroupSex = (RadioGroup) findViewById(R.id.RadioGroupSex);
		int selectedId = radioGroupSex.getCheckedRadioButtonId();
		radioButtonSex = (RadioButton) findViewById(selectedId);
		sex = radioButtonSex.getText().toString();
		
		//diag
		radioGroupDiag = (RadioGroup) findViewById(R.id.RadioGroupDiag);
		selectedId = radioGroupDiag.getCheckedRadioButtonId();
		radioButtonDiag = (RadioButton) findViewById(selectedId);
		diag = radioButtonDiag.getText().toString();
		
		
//		Log.i(ManagerTest.APP_NAME, "Age: " + age);
//		Log.i(ManagerTest.APP_NAME, "Sex: " + sex);
//		Log.i(ManagerTest.APP_NAME, "Sug: " + sug);
//
//		Log.i(ManagerTest.APP_NAME, "Result: " + result);
//		Log.i(ManagerTest.APP_NAME, "Diagnosticado: " + diag);

		
		Contact cn = new Contact(sex, age, result, diag, sug);
		new PostAsyncContact(this).execute(cn);

		Intent i = new Intent(this, ResultActivity.class);
		startActivity(i);
		
	}

}

//post contact to server or save in sqlite
class PostAsyncContact extends AsyncTask <Contact, Void, Void> {
   
	private Context mContext;
	
	public PostAsyncContact (Context cntx) {
		this.mContext = cntx;
	}
   	
   protected Void doInBackground(Contact... cn) {
//	   Log.i(ManagerTest.APP_NAME, "IN BACKGROUND" );
	   
	   SyncContact sync = new SyncContact(mContext);
	   
	   if (sync.hasActiveInternetConnection()) {
	 		sync.makePost(cn[0]);
	 	} else {
			DatabaseHandler db = new DatabaseHandler(mContext);
			db.addContact(cn[0]);	 		
	 	}
		
	   return null;
   }   
}