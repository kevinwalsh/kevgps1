package com.example.kevgps1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String classes[] = {"MainActivity", "LocationHistory", "SendLocation", "FindLocation", "TheNewBoston_sql", "SQLExample1_activity"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String selecteditem = classes[position];
		try{
		Class ourclass= Class.forName("com.example.kevgps1."+ selecteditem);
		Intent myintent = new Intent(Menu.this, ourclass);
		startActivity(myintent);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}


	
}
