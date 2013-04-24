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
    
	private ImageButton responderButton, avancarButton, helpButton;
	private ImageView visualizadorImagensTextView;
	private TextView entradaUsuarioTextView;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        
        carregarVariaveis();
        configurarImagens();
        listeners();    
    }
    /**
     * Carrega a imagem a ser visualizada
     */
    private void carregaImagem (){
    	visualizadorImagensTextView.setImageResource(ManagerTest.getImagemCorrente().getResourceId());
    }
    
    /**
     * Visualiza a activity de resultado
     */
    private void resultadoActivity(){
		Intent i = new Intent(this, ResultadoActivity.class);
        startActivity(i);
	}
    
    /**
     * Carrega o pr�ximo teste parcial ou encerra o teste se estes
     * j� tiverem findado
     */
    private void avancaTeste (){
    	Toast.makeText(TestActivity.this,"Resposta Correta!", Toast.LENGTH_SHORT).show();
    	Image imagemCorrente = ManagerTest.getImagemCorrente();
    	ManagerTest.setResposta(imagemCorrente.getValor());
    	if (!((imagemCorrente.getGrupoId()+1)==ManagerTest.getquantidadeGruposTeste())){
    		//resultadoPorGrupo.add(imagemCorrente.getValor());
    		ManagerTest.setIdImagemCorrente((ManagerTest.getImagemCorrente().getGrupoId()+1)*ManagerTest.getquantidadeTelasPorGrupo());
    		carregaImagem();
    		entradaUsuarioTextView.setText("");
    	}else{
    		resultadoActivity();
    	}
    	
    }
    /**
     * Visualiza a activity de ajuda
     */
    private void ajudaActivity (){
    	Intent i = new Intent (this, HelpActivity.class);
		startActivity(i);
    }
    
    
    private void continuaNoMesmoTeste(){
    	Toast.makeText(TestActivity.this,"Resposta Incorreta!", Toast.LENGTH_SHORT).show();
    	entradaUsuarioTextView.setText("");
    }
    
    /**
     * Carrega a pr�xima imagem, dentro de um grupo de teste.
     * Nao permite avancar se n�o responder corretamente a ultima
     * imagem do grupod de teste.
     */
    private void avancaImagem (){
    	Image imagemCorrente = ManagerTest.getImagemCorrente();
    	if (imagemCorrente.getIndiceGrupo() == (ManagerTest.getquantidadeTelasPorGrupo()-1) ){//se for a ultima tela do grupo
    		Toast.makeText(TestActivity.this,"Necess�rio responder para avan�ar!", Toast.LENGTH_SHORT).show();
    		carregaImagem();
    	}else{
    		ManagerTest.setIdImagemCorrente(ManagerTest.getIdImagemCorrente()+1);
    		carregaImagem();
    	}
    }
    
    /**
     * Contem os eventos listeners dos objetos
     */
    private void listeners (){
    	avancarButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				avancaImagem();
			}
		});
    	
    	
       	helpButton.setOnClickListener(new View.OnClickListener() {	
    			public void onClick(View v) {
    				ajudaActivity();
    			}
    		});
    	
    	responderButton.setOnClickListener(new View.OnClickListener() {	
			public void onClick(View v) {
				String entrada = entradaUsuarioTextView.getText().toString().trim();
				Image imagemCorrente = ManagerTest.getImagemCorrente();
				if (entrada.trim().length() !=0){
					if (imagemCorrente.isIgualId(entrada.charAt(0)+"")){
						avancaTeste();
					}else{
						continuaNoMesmoTeste();
					}
				}else{
					Toast.makeText(TestActivity.this,"Digite o s�mbolo que voce ve!", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    
    /**
     * Configura as imagens do teste, os grupos de teste,
     * e as quantidades dos mesmos
     */
    private void configurarImagens(){
    	ArrayList<Image> imagens = new ArrayList<Image>();    	
    	imagens.add(new Image(0,   0, 0, 0, R.drawable.imagem_1,"1"));
    	imagens.add(new Image(1, 1, 0, 1, R.drawable.imagem_2,"2"));
    	imagens.add(new Image(0,   2, 1, 0, R.drawable.imagem_3,"3"));
    	imagens.add(new Image(1, 3, 1, 1, R.drawable.imagem_4,"4"));
    	imagens.add(new Image(0,   4, 2, 0, R.drawable.imagem_5,"5"));
    	imagens.add(new Image(1, 5, 2, 1, R.drawable.imagem_6,"6"));
    	ManagerTest.setImagens(imagens);
    	ManagerTest.setquantidadeGruposTeste(3);
    	ManagerTest.setquantidadeTelasPorGrupo(2);
    }
    
    /**
     * Inicializa e carrega as vari�veis do aplicativo
     */
    private void carregarVariaveis (){
    	avancarButton               = (ImageButton)findViewById(R.id.avancar_imageButton);
    	responderButton             = (ImageButton)findViewById(R.id.responder_imageButton);
    	helpButton                  = (ImageButton)findViewById(R.id.help_imageButton);
    	visualizadorImagensTextView = (ImageView)findViewById(R.id.imagem_imageView);
    	entradaUsuarioTextView      = (TextView)findViewById(R.id.entrada_editText);
    	
    }
}