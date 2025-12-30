package com.library.DigitalLibrary.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.DigitalLibrary.Entity.Book;



@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

    

}
