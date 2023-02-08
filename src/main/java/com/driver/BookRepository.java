package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

	 private List<Book> bookList;
	    private int id;
    public BookRepository(){
    	 this.bookList = new ArrayList<>() ;
    	 this.id=1;
    }

    public Book save(Book book){
    	book.setId(id++);
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
    	for(Book book:bookList) {
    		if(book.getId()==id) {
    			return book;
    		}
    	}
    	return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
    	for(Book b:bookList) {
			if(b.getId()==id) {
				bookList.remove(b);
				break;
			}
		}
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor(String author){
    	 List<Book> authorBooks = new ArrayList<>();
         for (Book b : bookList) {
             if (b.getAuthor().equals(author)) {
                 authorBooks.add(b);
             }
         }
         return authorBooks;
    }

    public List<Book> findBooksByGenre(String genre){
    	List<Book> bookByGenre = new ArrayList<>();    
        for(Book b : bookList) {
       	 if(b.getGenre().equals(genre)) {
       		 bookByGenre.add(b);
       	 }
        }
        return bookByGenre;
    }
}
