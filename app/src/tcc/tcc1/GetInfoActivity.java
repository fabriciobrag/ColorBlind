package tcc.tcc1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class GetInfoActivity extends MenuOptions {

	private String sex, age = "", diag = "";
	private int result;
	
	private RadioGroup radioGroupSex, radioGroupDiag;
	private RadioButton radioButtonSex, radioButtonDiag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_info);
	}
	
	public void sendInfo (View button) {
		
		//age
		EditText ageField = (EditText) findViewById(R.id.EditTextAge);  
		age = ageField.getText().toString();  
		if (age.isEmpty()){
			age = "0";
		}
		
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
		
		
		Log.i(ManagerTest.APP_NAME, "Age: " + age);
		Log.i(ManagerTest.APP_NAME, "Sex: " + sex);
		Log.i(ManagerTest.APP_NAME, "Result: " + result);
		Log.i(ManagerTest.APP_NAME, "Diagnosticado: " + diag);

		
		SyncContact sync = new SyncContact(this);
		Contact cn = new Contact(sex, age, result, diag);

	 	if (sync.hasActiveInternetConnection()) {
	 		sync.makePost(cn);
	 	} else {
			DatabaseHandler db = new DatabaseHandler(this);
			db.addContact(cn);	 		
	 	}
		
		
		Intent i = new Intent(this, ResultActivity.class);
		startActivity(i);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_info, menu);
		return true;
	}

}
