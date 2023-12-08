package com.pepsi.webflux.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pepsi.webflux.Entity.SupportClass.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "author")
public class Author {
    @Id
    private ObjectId id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotNull(message = "Address should be present")
    private Address address;
    //private List<BookInfo> bookList;
    public Author(ObjectId id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
        //this.bookList=new ArrayList<>();
    }

    public Author() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<BookInfo> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<BookInfo> bookList) {
//        this.bookList = bookList;
//    }
}
