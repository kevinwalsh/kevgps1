package com.example.kevgps1;

import java.util.ArrayList;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
//this class is what determines what happens every time we get given an updated location
public class MyLocationListener implements LocationListener {
	private MainActivity main2;
	
	public MyLocationListener(MainActivity mainActivity) {
		this.main2 = mainActivity;		//kw this is tied to old main script, i.e. jacks original. ive switched main & main2.
	}

	private KevLocationFinder main;
	ArrayList<Location> locationlist;		//added 19-5-14 to try store all loc's as an arraylist, and send to main class
	public MyLocationListener(KevLocationFinder kevLocationFinder) {
		this.main=kevLocationFinder;
		locationlist= new ArrayList<Location>();
	}

	
	//this is the method that will get called when we get a new location
	//all we do is make a string and send it back to the main activity, pretty simple
	@Override
	public void onLocationChanged(Location location) {
		//here i just use a basic string, but i would recommend using a JSONObject for anything more complex,
		//especially if you want to send it over a network or something
		
		Location l = new Location (LocationManager.GPS_PROVIDER);
		l.setLatitude(53); //FYI, diff of approx 0.001 = 45m 
		l.setLongitude(-6);
		float distanceto= location.distanceTo(l)/1000;
		
		String result = "Longitude: "+location.getLongitude()+", Latitude: "+location.getLatitude()+
				", Accuracy: "+location.getAccuracy() +", dist to target: "+distanceto+" km";
		
		/*kw add*/ main.gpstofloat(location.getLatitude(), location.getLongitude());
		
		main.updateText(result);
		locationlist.add(location); 	//added JC 19-5-14
		
	}

	public ArrayList<Location> getLocationList() {   //another addition JC 19-5-14
		return locationlist;
	}
		
	//the rest of these callbacks can be used for stuff
	//but we're not really interested in them for now, so we leave them blank
	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
