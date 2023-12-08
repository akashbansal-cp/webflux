package com.pepsi.webflux.DTO;

import com.pepsi.webflux.Entity.Book;

public class BookInsertDTO {
    private Book book;
    private String authorName;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
