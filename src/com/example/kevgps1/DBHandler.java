package com.example.kevgps1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHandler  extends SQLiteOpenHelper{

//	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;
	
	private static final int DATABASE_VERSION = 2;
	private static final String kevgps_table_name = "kevgps_table";
	private static final String TAG = "kevgps_tag"; 
	
	private static final String DATABASE_CREATE =
            "CREATE TABLE if not exists " + kevgps_table_name + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "locationname TEXT, location TEXT, latitude FLOAT, longitude FLOAT, " +
            "date DATE, time TIME);";
	
	
	
	public DBHandler(Context context, String name, CursorFactory factory,
			int version) {
		super (context, kevgps_table_name, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
//		try{
			db.execSQL(DATABASE_CREATE);
//		}
//	catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
		


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(TAG, "upgrading the db from old version to new version- this will destroy all existing data!");
		db.execSQL("DROP TABLE IF EXISTS kevgps_table");
		onCreate(db);	
	}

	
	
	
	
}
