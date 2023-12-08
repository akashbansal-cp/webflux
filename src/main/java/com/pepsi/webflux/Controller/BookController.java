package com.pepsi.webflux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepsi.webflux.DTO.BookDTO;
import com.pepsi.webflux.DTO.BookInsertDTO;
import com.pepsi.webflux.Service.BookService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public Flux<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/getByGenre")
    public Flux<BookDTO> getBooksByGenre(@RequestParam String genre){
        return bookService.getBookByGenre(genre);
    }
    @GetMapping("/getByGenreAndCopiesCount")
    public Flux<BookDTO> getBooksByGenreAndCopies(@RequestParam String genre,@RequestParam int id){ return bookService.getBooksByGenreAndCopies(genre,id);}
    @GetMapping("/byAuthorsNames")
    public Flux<BookDTO> getBooksByAuthorsNames(@RequestParam String authorList){ return bookService.getBooksByAuthorsName(authorList);}
    @PostMapping
    public ResponseEntity<Mono<BookDTO>> addBook(@RequestBody @Valid BookInsertDTO request){
        return ResponseEntity.ok(bookService.addBook(request));
    }
}
