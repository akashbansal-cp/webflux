package com.pepsi.webflux.DTO;


import com.pepsi.webflux.Entity.SupportClass.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class AuthorDTO {
    @Id
    private ObjectId id;
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotNull(message = "Address should be present")
    private Address address;

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
}
