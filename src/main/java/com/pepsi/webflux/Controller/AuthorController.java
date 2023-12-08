package com.pepsi.webflux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pepsi.webflux.DTO.AuthorDTO;
import com.pepsi.webflux.Service.AuthorService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    public AuthorService authorService;

    @GetMapping
    public Flux<AuthorDTO> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    @GetMapping("/byNamesLike")
    public Flux<AuthorDTO> getAllByNamesLike(@RequestParam String authorPattern) {
        return authorService.getAllAuthorsByNamesLike(authorPattern);
    }

    @PostMapping
    public ResponseEntity<Mono<AuthorDTO>> addAuthor(@RequestBody @Valid AuthorDTO authorDTO){
        return ResponseEntity.ok(authorService.addAuthor(Mono.just(authorDTO)));
    }
}
