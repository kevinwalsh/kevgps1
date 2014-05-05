package com.example.kevgps1;


import java.util.List;
import com.example.kevgps1.Book;
import com.example.kevgps1.SQLExample1;


import android.os.Bundle;
import android.app.Activity;


public class SQLExample1_activity extends Activity {
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       //setContentView(R.layout.sqlexample_activity.xml);
	      setContentView(R.layout.sqlexample_activity);
	        
	        SQLExample1 db = new SQLExample1(this);
	 
	        /**
	         * CRUD Operations
	         * */
	        // add Books
	        db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));  
	        db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));      
	        db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
	 
	        // get all books
	        List<Book> list = db.getAllBooks();
	 
	        // delete one book
	        db.deleteBook(list.get(0));
	 
	        // get all books
	        db.getAllBooks();
	 
	    }
	 
	}
