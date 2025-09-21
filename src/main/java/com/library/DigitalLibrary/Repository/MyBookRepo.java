package com.library.DigitalLibrary.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.DigitalLibrary.Entity.MyBooks;

import jakarta.transaction.Transactional;


@Repository
public interface MyBookRepo extends JpaRepository<MyBooks, Integer> {

    @Query(value="SELECT * FROM my_books WHERE user_id=:userId", nativeQuery = true)
    List<MyBooks> findByUserId(int userId);

   
 
    @Modifying
    @Transactional
    @Query(value="DELETE FROM my_books WHERE id=:bookId AND user_id=:userId", nativeQuery=true)
    void deleteUserBook(int bookId, int userId);

}