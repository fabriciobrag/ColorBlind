package tcc.tcc1;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
     * Visualiza a activity de resultado
     */
    private void resultActivity(){
		Intent i = new Intent(this, ResultActivity.class);
        startActivity(i);
	}
    
    /**
     * Visualiza a activity de ajuda
     */
    private void helpActivity (){
    	Intent i = new Intent (this, HelpActivity.class);
		startActivity(i);
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
//					inputTextView.setText("");

//					answerButton.requestFocus();
//					Log.i(ManagerTest.APP_NAME, ""+getWindow().getCurrentFocus());
					
										
					//close keyboard
					InputMethodManager imm = (InputMethodManager)getSystemService(
						      Context.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(inputTextView.getWindowToken(), 0);
					
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
    	images.add(new Image(i++, R.drawable.img_206,"1"));
    	images.add(new Image(i++, R.drawable.img_206,"2"));
    	images.add(new Image(i++, R.drawable.img_206,"3"));
    	images.add(new Image(i++, R.drawable.img_206,"4"));
    	
    	ManagerTest.startTest(images);
    	
    }
   
}