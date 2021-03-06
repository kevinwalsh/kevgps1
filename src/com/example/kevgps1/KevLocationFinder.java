package com.example.kevgps1;

import java.util.ArrayList;
import java.util.List;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KevLocationFinder extends Activity {

	// a copy of jacks thing, i also had to add a duplicate constructor for THIS java file in "MyLocationListener.java"
	//i wanna play around with this and see what i can improve
	
	LocationManager lManager;
	MyLocationListener listener;
	ArrayList<Double> latList = new ArrayList<Double>();
	ArrayList<Location> locationlist = new ArrayList<Location>();
	//List<Point> gps = new ArrayList<Point>();			//cant use point because its int's only!!
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setButtonActionToStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//this is the basic method for starting location tracking
	//the two variables are the minimum time and minimum distance between updates
	//basically it means if you set them both to 5 then it would wait until 5ms had passed and
	//you had traveled 5m before updating. If you set them both to zero it will update as often as possible.

	public void getLocation(long minTime, float minDistance){
		updateText("Searching for location...",0);		// 1 = TVChooser, ie textview 0
		//the first of two steps to get a gps lock, to retrieve our location manager
		//this is an object provided by the OS which acts as our gateway to the hardware

		lManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		//here we instanciate our location listener

		listener = new MyLocationListener(this);
		//the second step is to ask for updates, and to pass an instace of our listener
		//our listener determines what action gets taken every time the OS returns with an updated location

		lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, listener);
	}
	
	//to stop tracking we request that the location manager stops giving updates to the listener
	//once all requests have been removed the gps will shut down
	public void stopTracking(){
		if(lManager!=null){
			lManager.removeUpdates(listener);
		}
	}
	
	public void updateText(String newText, int TVChooser){
		String TVSelector = "R.id.textView"+Integer.toString(TVChooser);
		//TextView textView = (TextView) findViewById(R.id.textView0); //old, general, static! 
		//TextView textView = (TextView) findViewById(TVSelector);	//doesnt work! online help suggests using getIdentifier!
	
		//int resultID= getResources().getIdentifier(TVSelector, "id", getPackageName());
		//TextView textView = (TextView) findViewById(resultID);
		
		TextView textView;
		switch (TVChooser) {
			case 0:  textView = (TextView) findViewById(R.id.textView0); break;
			case 1:  textView = (TextView) findViewById(R.id.textView1); break;
			case 2:  textView = (TextView) findViewById(R.id.textView2); break;
			case 3:  textView = (TextView) findViewById(R.id.textView3); break;
			case 4:  textView = (TextView) findViewById(R.id.textView4); break;
			default: textView = (TextView) findViewById(R.id.textView0); newText="error in switch/case loop in kevlocationfinder";

		}
		textView.setText(newText); 	//placed inside cos otherwise textView may never be initialised! error! (*edit, taken bk outside)		
		
	}
	
	public void gpstofloat(double latitude, double longitude) {
		TextView TVLat = (TextView) findViewById(R.id.textView2); 
		TextView TVLong = (TextView) findViewById(R.id.textView3);
		TVLat.setText ("now latitude as double = " + String.valueOf(latitude));
		latList.add(latitude);
		Double avg = GPSStats.Avg(latList); Double stdev = GPSStats.STDev(latList,avg);
		TVLong.setText ("average lat = " + String.valueOf(GPSStats.Avg(latList)) +", standard deviation = " +
				String.valueOf(GPSStats.STDev(latList, avg))+", or in metres, " +String.valueOf(GPSStats.STDev(latList, avg)));
		
	}
	

	public void setButtonActionToStart(){
		final Button button = (Button) findViewById(R.id.bStart);
		button.setText("Start tracking");
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getLocation(500, 1);		//	Heres where we assign vals for minTime & minDistance!!
				setButtonActionToStop();
			}
		});
	}
	private void setButtonActionToStop(){
		final Button button = (Button) findViewById(R.id.bStart);
		button.setText("Stop tracking");
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				stopTracking();
				setButtonActionToStart();
			}
		});
	}


	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		latList=null;
	}
	
}
