package com.example.kevgps1;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
//this class is what determines what happens every time we get given an updated location
public class MyLocationListener implements LocationListener {
	private MainActivity main;
	
	public MyLocationListener(MainActivity mainActivity) {
		this.main = mainActivity;
	}

	private KevLocationFinder main2;
	public MyLocationListener(KevLocationFinder kevLocationFinder) {
		this.main2=kevLocationFinder;
	}

	
	//this is the method that will get called when we get a new location
	//all we do is make a string and send it back to the main activity, pretty simple
	@Override
	public void onLocationChanged(Location location) {
		//here i just use a basic string, but i would recommend using a JSONObject for anything more complex,
		//especially if you want to send it over a network or something
		
		Location l = new Location (LocationManager.GPS_PROVIDER);
		l.setLatitude(53);
		l.setLongitude(-6);
		float distanceto= location.distanceTo(l)/1000;
		
		String result = "Longitude: "+location.getLongitude()+", Latitude: "+location.getLatitude()+
				", Accuracy: "+location.getAccuracy() +", dist to target: "+distanceto+" km";
		
		main.updateText(result);
		
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
