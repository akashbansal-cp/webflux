package com.pepsi.webflux.Repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pepsi.webflux.DTO.AuthorDTO;
import com.pepsi.webflux.Entity.Author;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AuthorRepo extends ReactiveMongoRepository<Author,String> {
    Mono<AuthorDTO> findByName(String name);
    @Query("{name:{$regex:?0, $options :'i'}}")
    Flux<AuthorDTO> searchAuthorsByNamesLike(String authorPattern);
}
