package com.takeo.bookinventorymgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		try {
			Connection con=DBConnection.getConnection();
		PreparedStatement ps=	con.prepareStatement("");//Insert query
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
