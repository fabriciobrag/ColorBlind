package tcc.tcc1;

import tcc.tcc1.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/**
 * Tela de resultados do aplicativo
 * @author Fabricio e Manoel
 *
 */
public class ResultActivity extends Activity{
	
	private TextView resultadoTextView, resultado_descricaoTextView;
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.resultado_activity);
	        carregaVariaveis();    
	    }
	  
	/**
	 * Incicializa e carrega as vairi�veis do resultado
	 */
	public void carregaVariaveis (){
		resultadoTextView = (TextView)findViewById(R.id.resultado_textView);
		resultado_descricaoTextView = (TextView)findViewById(R.id.resultado_descricao_textView);
		//Resultados possiveis dos testes, obtido por uma das funcoes de resultado 
		//(media, soma, moda, etc)
		switch (ManagerTest.getResultado()){
			case 0:
				resultadoTextView.setText(R.string.resultado_0);
				resultado_descricaoTextView.setText(R.string.resultado_0_descricao);
				break;
			case 1:
				resultadoTextView.setText(R.string.resultado_1);
				resultado_descricaoTextView.setText(R.string.resultado_1_descricao);
				break;
			case 2:
				resultadoTextView.setText(R.string.resultado_2);
				resultado_descricaoTextView.setText(R.string.resultado_2_descricao);
				break;
			case 3:
				resultadoTextView.setText(R.string.resultado_3);
				resultado_descricaoTextView.setText(R.string.resultado_3_descricao);
				break;
			case 4:
				resultadoTextView.setText(R.string.resultado_4);
				resultado_descricaoTextView.setText(R.string.resultado_4_descricao);
				break;
			case 5:
				resultadoTextView.setText(R.string.resultado_5);
				resultado_descricaoTextView.setText(R.string.resultado_5_descricao);
				break;
			default:
				resultadoTextView.setText("Erro");
				resultado_descricaoTextView.setText("Erro - resultado: " + ManagerTest.getResultado());
		}		
	}
}