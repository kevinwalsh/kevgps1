package com.example.kevgps1;

//this is an object, that relates to/is used by SQLExample1.java, which I got from a tutorial at http://hmkcode.com/android-simple-sqlite-database-tutorial/
	
	public class Book {
		 
	    private int id;
	    private String title;
	    private String author;
	 
	    public Book(){}
	 
	    public Book(String title, String author) {
	        super();
	        this.title = title;
	        this.author = author;
	    }
	 
	    //getters & setters
	 
	    @Override
	    public String toString() {
	        return "Book [id=" + id + ", title=" + title + ", author=" + author
	                + "]";
	    }
	    
	    
	    //-----------------------------------------
	    //hopefully the missing piece. see end of sqlExample1.java. grabbed from different/ unrelated example!
	    public int getId() {   return id;	}

	    public void setId(int id) {	    this.id = id;	  }
	   
	    public String getAuthor() {	    return author;	  }

	  public void setAuthor(String author) {	    this.author = author;	  }
	   
	  public String getTitle() {    return title;  }

	  public void setTitle(String title) {    this.title = title;  }
	   
	    
	}
