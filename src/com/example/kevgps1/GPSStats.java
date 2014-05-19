package com.example.kevgps1;

import java.util.ArrayList;


public class GPSStats {

	//hopefully using to give rough stats, averages, stdevs, etc, of the gps coordinates.
	//so pass in an array of lats & longs, and return as necessary, probably single Double variables.
	//then in main, have something simple like :
	// myTV.setText ("average lat = " + String.valueOf(GPSStats.Avg(latarray));
	
	public static Double Avg (ArrayList<Double> arraylist) {
		int i=0; Double average=0.0;
		if (arraylist==null||arraylist.isEmpty()) {return 0.0;}
		
		for (i=0;i<arraylist.size();i++) {average=average + arraylist.get(i);}
		average=average/arraylist.size();
		return average;
	}
	
	public static Double STDev (ArrayList<Double> arraylist, Double mean) {
		return 0.0;
	}
	
	public static Double Avg_test (ArrayList<Double> array) {
		return 1.0;
	}
	
}
