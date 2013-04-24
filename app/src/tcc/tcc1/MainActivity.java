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
 * @authors Fabrício e Manoel
 *
 */
public class MainActivity extends Activity {
    
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
    	visualizadorImagensTextView.setImageResource(GerenciaTeste.getImagemCorrente().getResourceId());
    }
    
    /**
     * Visualiza a activity de resultado
     */
    private void resultadoActivity(){
		Intent i = new Intent(this, ResultadoActivity.class);
        startActivity(i);
	}
    
    /**
     * Carrega o próximo teste parcial ou encerra o teste se estes
     * já tiverem findado
     */
    private void avancaTeste (){
    	Toast.makeText(MainActivity.this,"Resposta Correta!", Toast.LENGTH_SHORT).show();
    	Imagem imagemCorrente = GerenciaTeste.getImagemCorrente();
    	GerenciaTeste.setResposta(imagemCorrente.getValor());
    	if (!((imagemCorrente.getGrupoId()+1)==GerenciaTeste.getquantidadeGruposTeste())){
    		//resultadoPorGrupo.add(imagemCorrente.getValor());
    		GerenciaTeste.setIdImagemCorrente((GerenciaTeste.getImagemCorrente().getGrupoId()+1)*GerenciaTeste.getquantidadeTelasPorGrupo());
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
    	Intent i = new Intent (this, AjudaActivity.class);
		startActivity(i);
    }
    
    
    private void continuaNoMesmoTeste(){
    	Toast.makeText(MainActivity.this,"Resposta Incorreta!", Toast.LENGTH_SHORT).show();
    	entradaUsuarioTextView.setText("");
    }
    
    /**
     * Carrega a próxima imagem, dentro de um grupo de teste.
     * Nao permite avancar se não responder corretamente a ultima
     * imagem do grupod de teste.
     */
    private void avancaImagem (){
    	Imagem imagemCorrente = GerenciaTeste.getImagemCorrente();
    	if (imagemCorrente.getIndiceGrupo() == (GerenciaTeste.getquantidadeTelasPorGrupo()-1) ){//se for a ultima tela do grupo
    		Toast.makeText(MainActivity.this,"Necessário responder para avançar!", Toast.LENGTH_SHORT).show();
    		carregaImagem();
    	}else{
    		GerenciaTeste.setIdImagemCorrente(GerenciaTeste.getIdImagemCorrente()+1);
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
				Imagem imagemCorrente = GerenciaTeste.getImagemCorrente();
				if (entrada.trim().length() !=0){
					if (imagemCorrente.isIgualId(entrada.charAt(0)+"")){
						avancaTeste();
					}else{
						continuaNoMesmoTeste();
					}
				}else{
					Toast.makeText(MainActivity.this,"Digite o símbolo que voce ve!", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    
    /**
     * Configura as imagens do teste, os grupos de teste,
     * e as quantidades dos mesmos
     */
    private void configurarImagens(){
    	ArrayList<Imagem> imagens = new ArrayList<Imagem>();    	
    	imagens.add(new Imagem(0,   0, 0, 0, R.drawable.imagem_1,"1"));
    	imagens.add(new Imagem(1, 1, 0, 1, R.drawable.imagem_2,"2"));
    	imagens.add(new Imagem(0,   2, 1, 0, R.drawable.imagem_3,"3"));
    	imagens.add(new Imagem(1, 3, 1, 1, R.drawable.imagem_4,"4"));
    	imagens.add(new Imagem(0,   4, 2, 0, R.drawable.imagem_5,"5"));
    	imagens.add(new Imagem(1, 5, 2, 1, R.drawable.imagem_6,"6"));
    	GerenciaTeste.setImagens(imagens);
    	GerenciaTeste.setquantidadeGruposTeste(3);
    	GerenciaTeste.setquantidadeTelasPorGrupo(2);
    }
    
    /**
     * Inicializa e carrega as variáveis do aplicativo
     */
    private void carregarVariaveis (){
    	avancarButton               = (ImageButton)findViewById(R.id.avancar_imageButton);
    	responderButton             = (ImageButton)findViewById(R.id.responder_imageButton);
    	helpButton                  = (ImageButton)findViewById(R.id.help_imageButton);
    	visualizadorImagensTextView = (ImageView)findViewById(R.id.imagem_imageView);
    	entradaUsuarioTextView      = (TextView)findViewById(R.id.entrada_editText);
    	
    }
}