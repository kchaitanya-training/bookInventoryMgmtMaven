package com.takeo.bookinventorymgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.takeo.bookinventorymgmt.exception.BookInventoryException;
import com.takeo.bookinventorymgmt.model.Book;
import com.takeo.bookinventorymgmt.util.DBConnection;

public class BookInventory {
	
	
	List<Book> bookList;
	public BookInventory() {
		this.bookList=new ArrayList();
	}
	
	public void addBook(Book book) throws BookInventoryException{
		System.out.println("book "+book.getBookName());
		PreparedStatement ps=null;
		  Connection con=null;
		try {
			
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd");

			String currentTime = sdf.format(dt);
			
	    
	     con=DBConnection.getConnection();
	     ps=con.prepareStatement("SELECT MAX(BOOK_ID) FROM bookinventory");
	   ResultSet rs=  ps.executeQuery();
	   int maxId=0;
	   while(rs.next()) {
		   maxId=rs.getInt(1);
	   }
	    
	    
	    
		 ps=	con.prepareStatement("insert into bookinventory values"
				+ "(?,?,?,?,?,?)");//Insert query
		ps.setInt(1, ++maxId);
		ps.setString(2, book.getBookName());
		ps.setString(3, book.getBookDescription());
		ps.setDouble(4, book.getPrice());
		ps.setString(5, currentTime);
		ps.setString(6, "YES");
		
		ps.execute();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}
	
	public List<Book> getBook(){
		return bookList;
	}
	
	
	public List<String> getBookNames(){
		List<String> list=new ArrayList();

		
		
		return list;
	}
	
	public void updateBookName(Book book,String bookName){
		
	}

}
