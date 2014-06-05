package com.example.kevgps1;

import android.location.Location;
import android.location.LocationManager;

public class GPSTarget {

	double targetLat=53.0;
	double targetLong= -6.0;
	//Location targetLocation= new Location(LocationManager.GPS_PROVIDER);
	Location targetLocation;	//just to initialize incase needed
	String targetstring = "default, 53, -6, approx dun laoighre(?)";
	
	
	
	public Location setTarget (double latitude, double longitude) {			//ideally for if someone texts us a lat & long double
		targetLocation.setLatitude(latitude);
		targetLocation.setLongitude(longitude);
		return targetLocation;	
	}

	public Location setTarget (String textmessage) {			//maybe even just take in the text as a string
		targetLat = textparse(textmessage, 0);			//will try use the ints to find the Nth number in the text string
		targetLong = textparse(textmessage,1);
		return targetLocation;	
	}
	
	public Location setTarget (Location target) {				//shouldnt need this, dont see how we'd be sent a location object itself 
		targetLocation.set(target);								//atm this is just returning the same Location data that comes in.
		return targetLocation;
		
	}
	
	
	
	public double textparse(String text, int whichnumber) {		//whichnumber essentially means skip the first x numbers, prob separated
															//by whitespaces or maybe commas. do commas for now 
		String numbersonly_string = stripletters(text, whichnumber); 
		Double result = Double.parseDouble(numbersonly_string);
		result = 0.9; //junk for now
	return result;
	}
	
	public String stripletters(String text, int whichnumber) {
		//insert here somewhere some way of deleting every char one by one until we reach a whitespace/ comma,
		//and then NOT exiting loop actually.... rather reducing "whichnumber" count by 1.
		// then when whichnumber =0, exit loop, and record the number value, and delete any remainder text....
		text = text.replaceAll("[^0-9]+", " ");		// I THINK this is stripping out all letters & text that is not 0-9
		
		return "12345";
	}
	
	
	
}
