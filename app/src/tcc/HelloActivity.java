package tcc;

import tcc.tcc1.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Tela incial do aplicativo.
 * @authors Fabr�cio e Manoel
 *
 */
public class HelloActivity extends Activity{
	
	private ImageButton startImageButton, helpImagepButton;

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.boas_vindas_activity);
        carregaVariaveis();
        listeners();
	}
	
	/**
	 * Realiza a inicializa��o das vari�veis
	 */
	private void carregaVariaveis (){
		helpImagepButton = (ImageButton)findViewById(R.id.help_imageButtonBoasVindas);
		startImageButton = (ImageButton)findViewById(R.id.start_ImageButton);
	}
	
	/**
	 * Conjunto de metodos listeners
	 */
	private void listeners (){
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
	private void mainActivity(){
		Intent i = new Intent(this, TestActivity.class);
        startActivity(i);
	}
	
	/**
	 * Inicia a activity de ajuda
	 */
	private void helpActivity(){
		Intent i = new Intent(this, HelpActivity.class);
        startActivity(i);
	}
}
