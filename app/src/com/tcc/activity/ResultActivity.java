package com.tcc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tcc.app.ManagerTest;

/**
 * Tela de resultados do aplicativo
 * 
 * @author Fabricio e Manoel
 * 
 */
public class ResultActivity extends MenuOptions {

	private TextView resultTextView, result_descTextView;
	private Button repeatButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		//sherlock theme
        setTheme(R.style.Theme_Sherlock); 

		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_activity);
		
		repeatButton = (Button) findViewById(R.id.repeat_test);
		repeatButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mainActivity();
				
			}
		});
		
		loadResult();
	}
	
	private void mainActivity() {
		Intent i = new Intent(this, TestActivity.class);
		startActivity(i);
	}

	public void loadResult() {
		resultTextView = (TextView) findViewById(R.id.resultado_textView);
		result_descTextView = (TextView) findViewById(R.id.result_desc);

		int percent = ManagerTest.getResultPercent();

		
		String strMeatMsg = "Resultado: " + percent + "% de acerto";
		resultTextView.setText(strMeatMsg);

		if (percent >= 0 && percent <= 29) {
			result_descTextView.setText(R.string.result_2_desc);

		} else if (percent >= 30 && percent <= 69) {
			result_descTextView.setText(R.string.result_1_desc);

		} else if (percent >= 70 && percent <= 100) {
			result_descTextView.setText(R.string.result_0_desc);

		}

	}
}