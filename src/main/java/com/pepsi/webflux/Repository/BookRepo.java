package com.pepsi.webflux.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.pepsi.webflux.DTO.BookDTO;
import com.pepsi.webflux.Entity.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepo extends ReactiveMongoRepository <Book,String>{
    Flux<BookDTO> findByGenre(String genre);
    //custom queries
    @Query("{'genre' : ?0, 'copiesAvailable' : {$gte : ?1} }")
    Flux<BookDTO> searchByGenreAndCopiesCount(String genre, int copiesAvailable);

    @Query("{_id : ?0}")
    Mono<BookDTO> getById(ObjectId bookId);
    @Query("{authorId: ?0}")
    Flux<BookDTO> findBookWhereAuthorIsIn(ObjectId authorId);
}
