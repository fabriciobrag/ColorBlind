package tcc.tcc1;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity principal do aplicativo
 * @authors Fabr�cio e Manoel
 *
 */
public class TestActivity extends Activity {
    
	private ImageButton answerButton, helpButton;
	private ImageView imgImageView;
	private TextView inputTextView;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        
        this.answerButton  = (ImageButton)findViewById(R.id.responder_imageButton);
    	this.helpButton  = (ImageButton)findViewById(R.id.help_imageButton);
    	this.imgImageView = (ImageView)findViewById(R.id.imagem_imageView);
    	this.inputTextView  = (TextView)findViewById(R.id.entrada_editText);
        
        startTest();
        listeners();    
    }
    /**
     * Carrega a imagem a ser visualizada
     */
    private void carregaImagem (){
//    	imgImageView.setImageResource(ManagerTest.getImagemCorrente().getResourceId());
    }
    
    /**
     * Visualiza a activity de resultado
     */
    private void resultActivity(){
		Intent i = new Intent(this, ResultActivity.class);
        startActivity(i);
	}
    
    /**
     * Carrega o pr�ximo teste parcial ou encerra o teste se estes
     * j� tiverem findado
     */
    private void avancaTeste (){
    	/*Toast.makeText(TestActivity.this,"Resposta Correta!", Toast.LENGTH_SHORT).show();
    	Image imagemCorrente = ManagerTest.getImagemCorrente();
    	ManagerTest.setResposta(imagemCorrente.getValor());
    	if (!((imagemCorrente.getGrupoId()+1)==ManagerTest.getquantidadeGruposTeste())){
    		//resultadoPorGrupo.add(imagemCorrente.getValor());
    		ManagerTest.setIdImagemCorrente((ManagerTest.getImagemCorrente().getGrupoId()+1)*ManagerTest.getquantidadeTelasPorGrupo());
    		carregaImagem();
    		inputTextView.setText("");
    	}else{
    		resultadoActivity();
    	}*/
    	
    }
    /**
     * Visualiza a activity de ajuda
     */
    private void helpActivity (){
    	Intent i = new Intent (this, HelpActivity.class);
		startActivity(i);
    }
    
    
   
    
    /**
     * Carrega a pr�xima imagem, dentro de um grupo de teste.
     * Nao permite avancar se n�o responder corretamente a ultima
     * imagem do grupod de teste.
     */
    private void avancaImagem (){
    	/*Image imagemCorrente = ManagerTest.getImagemCorrente();
    	if (imagemCorrente.getIndiceGrupo() == (ManagerTest.getquantidadeTelasPorGrupo()-1) ){//se for a ultima tela do grupo
    		Toast.makeText(TestActivity.this,"Necess�rio responder para avan�ar!", Toast.LENGTH_SHORT).show();
    		carregaImagem();
    	}else{
    		ManagerTest.setIdImagemCorrente(ManagerTest.getIdImagemCorrente()+1);
    		carregaImagem();
    	}*/
    }
    
    /**
     * Contem os eventos listeners dos objetos
     */
    private void listeners (){
    	
    	
       	helpButton.setOnClickListener(new View.OnClickListener() {	
    			public void onClick(View v) {
    				helpActivity();
    			}
    		});
    	
    	answerButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				String input = inputTextView.getText().toString().trim();
				
				if (input.isEmpty()) {
					Toast.makeText(TestActivity.this,"Digite o símbolo que voce ve!", Toast.LENGTH_SHORT).show();
					return;
				} 
				
				ManagerTest.setAnswer(input);
				if (ManagerTest.hasNext()) {
					
					imgImageView.setImageResource(ManagerTest.next().getResourceId());
				} else {
					resultActivity();
				}
				
				
			}
		});
    }
    
    /**
     * Configura as imagens do teste, os grupos de teste,
     * e as quantidades dos mesmos
     */
    private void startTest(){
    	ArrayList<Image> images = new ArrayList<Image>(); 
    	int i = 0;
    	images.add(new Image(i++, R.drawable.imagem_1,"1"));
    	images.add(new Image(i++, R.drawable.imagem_2,"2"));
    	images.add(new Image(i++, R.drawable.imagem_3,"3"));
    	images.add(new Image(i++, R.drawable.imagem_4,"4"));
    	
    	ManagerTest.startTest(images);

    }
    
    /**
     * Inicializa e carrega as vari�veis do aplicativo
     */
    private void loadVariables (){
    	
    	
    }
}