package com.library.DigitalLibrary.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity(name="my_books")
public class MyBooks {

    @Id  
    private int id;

    private String name;
    private String author;

    private int userId;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

}

