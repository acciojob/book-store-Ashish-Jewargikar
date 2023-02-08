package com.driver;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
    	Book book=bookService.findBookById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
   
    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
    	 List<Book> list=bookService.findAllBooks();
         return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author) {
    	List<Book> list=new ArrayList<>();
        list=bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
      
    @GetMapping("/get-books-by-genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String genre){
    	 List<Book> list=new ArrayList<>();
         list=bookService.findBooksByGenre(genre);
         return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-book-by-id/{id}")
    	public ResponseEntity<String> deleteBookById(@PathVariable String id){
    	bookService.deleteBookById(id);
        return new ResponseEntity<>("Successfully deleted.",HttpStatus.OK);
    	}
    
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String>deleteAllBooks(){
    	 bookService.deleteAllBooks();
         return new ResponseEntity<>("Successfully deleted.", HttpStatus.OK);
    }
}
