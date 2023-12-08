package com.pepsi.webflux.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepsi.webflux.DTO.AuthorDTO;
import com.pepsi.webflux.DTO.BookDTO;
import com.pepsi.webflux.DTO.BookInsertDTO;
import com.pepsi.webflux.Repository.AuthorRepo;
import com.pepsi.webflux.Repository.BookRepo;
import com.pepsi.webflux.Utils.BookUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorRepo authorRepo;
    public Flux<BookDTO> getAllBooks(){
        return bookRepo.findAll().map(BookUtil::entityToDTO);
    }
    public Flux<BookDTO> getBookByGenre(String genre){
        return bookRepo.findByGenre(genre);
    }

    public Mono<BookDTO> addBook(BookInsertDTO requestMono){
        String authorName=requestMono.getAuthorName();
        Mono<BookDTO> bookDTOMono=authorRepo.findByName(authorName)
                .flatMap((author) -> {
                    if(author!=null) {
                        BookDTO saveBook = BookUtil.entityToDTO(requestMono.getBook());
                        saveBook.setAuthorId(author.getId());
                        return Mono.just(saveBook);
                    }
                    else{
                        return Mono.error(new NullPointerException("Author Not found"));
                    }
                });
        Mono<BookDTO> response=bookDTOMono.map(BookUtil::dtoToEntity)
                .flatMap(bookRepo::insert)
                .map(BookUtil::entityToDTO);
        System.out.println("Book saved");
        return response;
    }

    public Flux<BookDTO> getBooksByGenreAndCopies(String genre, int id) {
        return bookRepo.searchByGenreAndCopiesCount(genre,id);
    }

    public Flux<BookDTO> getBooksByAuthorsName(String authorList) {
        String[] authors= authorList.split(":");
        return Flux.fromArray(authors)
                .flatMap(authorName -> authorRepo.findByName(authorName)
                        .flatMapMany(this::getBooks));
    }
    private Flux<BookDTO> getBooks(AuthorDTO authorDTO){
        if(authorDTO!=null && authorDTO.getId()!=null){
            return bookRepo.findBookWhereAuthorIsIn(authorDTO.getId());
        }
        else{
            return Flux.empty();
        }
    }
}
