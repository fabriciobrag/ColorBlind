package com.tcc.activity;

import com.tcc.app.ManagerTest;

import tcc.tcc1.R;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Tela de resultados do aplicativo
 * 
 * @author Fabricio e Manoel
 * 
 */
public class ResultActivity extends MenuOptions {

	private TextView resultTextView, result_descTextView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//sherlock theme
        setTheme(R.style.Theme_Sherlock); 

		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_activity);
		loadResult();
	}

	public void loadResult() {
		resultTextView = (TextView) findViewById(R.id.resultado_textView);
		result_descTextView = (TextView) findViewById(R.id.resultado_descricao_textView);

		int percent = ManagerTest.getResultPercent();

		// DatabaseHandler db = new DatabaseHandler(this);
		//
		// db.addContact(new Contact("M", "12", percent, "Y"));
		//
		// Log.d("Reading: ", "Reading all contacts..");
		// List<Contact> contacts = db.getAllContacts();
		//
		// for (Contact cn : contacts) {
		// String log = "Id: "+cn.get_id()+" , sex: " + cn.get_sex() +
		// " , age: " + cn.get_age();
		// Log.d("Name: ", log);
		// }
		//
		// Log.i(ManagerTest.APP_NAME, " Resultado % " +
		// ManagerTest.getResultPercent());
		//
		String strMeatMsg = "RESULTADO " + percent + "% acerto";
		resultTextView.setText(strMeatMsg);

		if (percent >= 0 && percent <= 29) {
			result_descTextView.setText(R.string.result_0_desc);

		} else if (percent > 30 && percent <= 69) {
			result_descTextView.setText(R.string.result_1_desc);

		} else if (percent > 70 && percent <= 100) {
			result_descTextView.setText(R.string.result_2_desc);

		}

	}
}