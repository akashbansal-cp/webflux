package com.pepsi.webflux.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "book")
public class Book {

    @Id
    private ObjectId id;
    @NotBlank(message = "Name is mandatory")
    private String bookName;
    @NotBlank(message = "Genre is mandatory")
    private String genre;
    @Min(value=1)
    private int copiesAvailable;
    private ObjectId authorId;

    public Book() {
    }

    public Book(ObjectId id, String bookName, String genre, int copiesAvaliable) {
        this.id = id;
        this.bookName = bookName;
        this.genre = genre;
        this.copiesAvailable = copiesAvaliable;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public ObjectId getAuthorId() {
        return authorId;
    }

    public void setAuthorId(ObjectId authorId) {
        this.authorId = authorId;
    }
}
