package tcc;

import tcc.tcc1.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Tela de ajuda do aplicativo
 * @authors Fabr�cio e Manoel
 *
 */
public class HelpActivity extends Activity {

	private Button okButton;
	private TextView textoAjudaTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ajuda_activity);
		carregaVariaveis();
		listeners();
	}
	
	/**
	 * Inicaliza as variaveis
	 */
	private void carregaVariaveis (){
		okButton = (Button)findViewById(R.id.ok_button);
		textoAjudaTextView = (TextView)findViewById(R.id.ajuda_textView);
		textoAjudaTextView.setText(R.string.texto_ajuda);
	}
	
	/**
	 * Metodos listener dos objetos
	 */
	private void listeners(){
		okButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				finish(); //retorna para a activity mais acima na pilha
			}
		});
	}
}
