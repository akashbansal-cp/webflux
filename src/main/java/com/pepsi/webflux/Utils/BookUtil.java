package com.pepsi.webflux.Utils;

import org.springframework.beans.BeanUtils;

import com.pepsi.webflux.DTO.BookDTO;
import com.pepsi.webflux.Entity.Book;

public class BookUtil {
    public static BookDTO entityToDTO (Book book){
        BookDTO dto=new BookDTO();
        BeanUtils.copyProperties(book,dto);
        return dto;
    }
    public static Book dtoToEntity (BookDTO dto){
        Book book=new Book();
        BeanUtils.copyProperties(dto,book);
        return book;
    }
}
