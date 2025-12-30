package com.library.DigitalLibrary.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.library.DigitalLibrary.Entity.Book;
import com.library.DigitalLibrary.Entity.MyBooks;
import com.library.DigitalLibrary.Service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class BookController {


    @Autowired
    private BookService bookService;



    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView availableBooks() {
        List<Book> books= bookService.getAllBooks();
        ModelAndView mv= new ModelAndView();
        mv.setViewName("bookList");
        mv.addObject("books", books);
        return mv;
    }

    @PostMapping("/save")
    public String addBook( @ModelAttribute Book book) {
        bookService.save(book);
       return "redirect:/available_books";
    }


    @GetMapping("/my_books/{userId}")
    public ModelAndView getMyBooks(@PathVariable("userId")  int userId) {
        List<MyBooks> allUserBooks= bookService.getAllUserBooks(userId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myBooks");
        modelAndView.addObject("myBooks", allUserBooks);
        return modelAndView;
    }

    @RequestMapping("/saveToMyBooks/{id}/{userId}")
    public String saveToMyBooks(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        Book book= bookService.getByBookId(id);
        MyBooks myBooks= new MyBooks();
        myBooks.setId(book.getId());
        myBooks.setName(book.getName());
        myBooks.setAuthor(book.getAuthor());
        myBooks.setUserId(userId);
        bookService.saveMyBooks(myBooks);    
        return "redirect:/my_books/"+userId;
    }

    @RequestMapping("/delete_my_book/{id}/{userId}")
    public String deleteMyBook(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        bookService.deleteUserBook(id, userId);
        return "redirect:/my_books/"+userId;
    }
    
    @GetMapping("/logout_user")
    public String logoutUser(){

        return "Welcome";
    }



}
