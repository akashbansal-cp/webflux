package com.pepsi.webflux.Utils;

import org.springframework.beans.BeanUtils;

import com.pepsi.webflux.DTO.AuthorDTO;
import com.pepsi.webflux.Entity.Author;

public class AuthorUtil {
    public static AuthorDTO entityToDTO(Author author){
        AuthorDTO dto=new AuthorDTO();
        BeanUtils.copyProperties(author,dto);
        return dto;
    }
    public static Author dtoToEntity (AuthorDTO dto){
        Author author=new Author();
        BeanUtils.copyProperties(dto,author);
        return author;
    }
}
