package tcc.tcc1;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "contactsManager";

	private static final String TABLE_CONTACTS = "contacts";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_SEX = "name";
	private static final String KEY_RESULT = "name";
	private static final String KEY_AGE = "phone_number";
	private static final String KEY_DIAG = "diag";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_SEX + " TEXT,"
				+ KEY_AGE + " TEXT," + KEY_RESULT + " TEXT," 
				+ KEY_DIAG + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	void addContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_SEX, contact.get_sex()); 
		values.put(KEY_AGE, contact.get_age()); 
		values.put(KEY_RESULT, contact.get_result()); 
		values.put(KEY_DIAG, contact.get_diag());

		// Inserting Row
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); 
	}

	// Getting single contact
	Contact getContact(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
				KEY_SEX, KEY_AGE, KEY_RESULT, KEY_DIAG }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)),
				cursor.getString(4));
		// return contact
		return contact;
	}
	
	// Getting All Contacts
	public List<Contact> getAllContacts() {
		List<Contact> contactList = new ArrayList<Contact>();
		String selectQuery = "SELECT " + KEY_SEX + ", " 
									   + KEY_AGE + ", " 
									   + KEY_RESULT + ", " 
									   + KEY_DIAG 									   
							+ " FROM " + TABLE_CONTACTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Contact contact = new Contact();
				contact.set_id(Integer.parseInt(cursor.getString(0)));
				contact.set_sex(cursor.getString(1));
				contact.set_age(cursor.getString(2));
				contact.set_result(Integer.parseInt(cursor.getString(3)));
				contact.set_diag(cursor.getString(4));
				
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}

		return contactList;
	}

	// Updating single contact
	public int updateContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_SEX, contact.get_sex());
		values.put(KEY_AGE, contact.get_age());
		values.put(KEY_RESULT, contact.get_result());
		values.put(KEY_DIAG, contact.get_diag());
		
		// updating row
		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
				new String[] { String.valueOf(contact.get_id()) });
	}

	// Deleting single contact
	public void deleteContact(Contact contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
				new String[] { String.valueOf(contact.get_id()) });
		db.close();
	}


	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

}
