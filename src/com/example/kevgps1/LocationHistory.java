package com.example.kevgps1;

/*public class LocationHistory extends SQLiteOpenHelper {
// was gonna use contentProvider to store locations as a database, but apparently thats more for sharing content between apps
// Instead, i think i can just use a general SQLite database?
	
	 private static final int DATABASE_VERSION = 2;
	 private static final String kevGPS_table_name = "GPS history";
	 
	 private static final String kevGPS_table_create =
	                "CREATE TABLE if not exists " + kevGPS_table_name + " (" +
	                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
	                "locationname TEXT, location TEXT, latitude FLOAT, longitude FLOAT, " +
	                "date DATE, time TIME);";

	
		LocationHistory (Context context) {
			super (context,kevGPS_database, null, DATABASE_VERSION)
		}
		public LocationHistory(){};
		public LocationHistory (String locationname, String location, float latitude, float longitude, Date date, Time time ) {
	        super();
	        this.title = title;
	        this.author = author;
		}
	        
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL(kevGPS_table_create);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
	
		
		public void addentry ()

		}
	*/	

