package tcc.tcc1;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuOptions extends Activity{
	
	@Override
	public boolean onCreateOptionsMenu (Menu menu){
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.menu_info, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.menu_about:
	        	helpActivity();
	            return true;
	        case R.id.menu_help:
	        	helpActivity();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}


	/**
	 * Inicia a activity de ajuda
	 */
	public void helpActivity() {
		Intent i = new Intent(this, CameraActivity.class);
		startActivity(i);
	}

}
