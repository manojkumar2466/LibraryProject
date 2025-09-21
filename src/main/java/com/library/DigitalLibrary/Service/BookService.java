package com.library.DigitalLibrary.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.DigitalLibrary.Entity.Book;
import com.library.DigitalLibrary.Repository.BookRepo;
import com.library.DigitalLibrary.Entity.MyBooks;
import com.library.DigitalLibrary.Repository.MyBookRepo;

@Service
public class BookService  {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private MyBookRepo myBookRepo;

    public void save(Book book){
        bookRepo.save(book);
        
    }


    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public List<MyBooks> getAllMyBooks(){
        return myBookRepo.findAll();
    }


    public void saveMyBooks(MyBooks book) {
        myBookRepo.save(book);
    }


    public Book getByBookId(int id) {
        return bookRepo.findById(id).orElse(null);
    }


   
    


    public List<MyBooks> getAllUserBooks(int userId) {
     
       return  myBookRepo.findByUserId(userId);
    }


    public void deleteUserBook(int id, int userId) {
       
        myBookRepo.deleteUserBook(id,userId);
    }

}
