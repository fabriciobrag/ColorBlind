/**
 * 
 */
package tcc.tcc1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * @author fabricio
 *
 */

public abstract class ResultContract {


	public static abstract class ResultEntry implements BaseColumns {
	
		public static final String TABLE_NAME ="result";
		
		public static final String COLUMN_NAME_RESULT_ID = "entryid";
	    public static final String COLUMN_NAME_AGE = "age";
	    public static final String COLUMN_NAME_SEX = "sex";
	    public static final String COLUMN_NAME_RESULT = "result";
	    public static final String COLUMN_NAME_DIAG = "diag";
		
	}
	private ResultContract() {}
	
	
	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_ENTRIES =
	    "CREATE TABLE " + ResultContract.ResultEntry.TABLE_NAME + " (" +
		ResultContract.ResultEntry._ID + " INTEGER PRIMARY KEY," +
		ResultContract.ResultEntry.COLUMN_NAME_AGE + TEXT_TYPE + COMMA_SEP +
		ResultContract.ResultEntry.COLUMN_NAME_SEX + TEXT_TYPE + COMMA_SEP +
	    ResultContract.ResultEntry.COLUMN_NAME_RESULT + TEXT_TYPE + COMMA_SEP +
		ResultContract.ResultEntry.COLUMN_NAME_DIAG + TEXT_TYPE + COMMA_SEP +
	    " )";

	private static final String SQL_DELETE_ENTRIES =
	    "DROP TABLE IF EXISTS " + ResultContract.ResultEntry.TABLE_NAME;
	
	public class ResultReaderDbHelper extends SQLiteOpenHelper {
	    // If you change the database schema, you must increment the database version.
	    public static final int DATABASE_VERSION = 1;
	    public static final String DATABASE_NAME = "FeedReader.db";

	    public ResultReaderDbHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }
	    public void onCreate(SQLiteDatabase db) {
	        db.execSQL(SQL_CREATE_ENTRIES);
	    }
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // This database is only a cache for online data, so its upgrade policy is
	        // to simply to discard the data and start over
	        db.execSQL(SQL_DELETE_ENTRIES);
	        onCreate(db);
	    }
	    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        onUpgrade(db, oldVersion, newVersion);
	    }
	    

	}


}
