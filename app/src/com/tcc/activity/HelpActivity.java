package com.tcc.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Tela de ajuda do aplicativo
 * 
 * @authors Fabrício e Manoel
 * 
 */
public class HelpActivity extends MenuOptions {

	private Button okButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//sherlock theme
        setTheme(R.style.Theme_Sherlock); 

		super.onCreate(savedInstanceState);

		setContentView(R.layout.help_activity);
		okButton = (Button) findViewById(R.id.help_ok_button);		
		okButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				finish(); // retorna para a activity mais acima na pilha
			}
		});
	}


}