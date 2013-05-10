package tcc.tcc1;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Tela de resultados do aplicativo
 * 
 * @author Fabricio e Manoel
 * 
 */
public class ResultActivity extends Activity {

	private TextView resultTextView, result_descTextView;

	public void onCreate(Bundle savedInstanceState) {
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