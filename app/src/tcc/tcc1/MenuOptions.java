package tcc.tcc1;

import android.content.Intent;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MenuOptions extends SherlockActivity {
	
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
    	menu.add("Sobre")
        	.setIntent(new Intent(this, HelpActivity.class))
            .setIcon(R.drawable.action_about)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        menu.add("Camera")
        	.setIntent(new Intent(this, CameraActivity.class))
            .setIcon(R.drawable.ic_camera)
            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        menu.add("Ajuda")
        	.setIntent(new Intent(this, HelpActivity.class))
	        .setIcon(R.drawable.action_help)
	        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        return true;
    }
    
	
	
	/**
	 * Inicia a activity de ajuda
	 */
	public void helpActivity() {
		Intent i = new Intent(this, CameraActivity.class);
		startActivity(i);
	}

}
