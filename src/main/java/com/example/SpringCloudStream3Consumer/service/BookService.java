package com.example.SpringCloudStream3Consumer.service;

import com.example.SpringCloudStream3Consumer.model.Book;
import com.example.SpringCloudStream3Consumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WebClient webClient;

    public Book updateBook(Book book) {
        book.setBookName(book.getBookName().toUpperCase());
        bookRepository.findById(book.getId()).ifPresent(book1 -> {
            book.setBookIsbn(book1.getBookIsbn());
            book.setAuthorId(book1.getAuthorId());
        });

       /* Mono<Book> bookMono = webClient
                .method(HttpMethod.GET)
                .uri("http://localhost:9898/rx/getBookDetails/" + book.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
                .retrieve()
                .onStatus(HttpStatus::isError, response -> Mono.error(new RuntimeException("Exception :: " + response)))
                .bodyToMono(Book.class)
                .retryWhen(Retry.backoff(3, Duration.ofSeconds(1)))
                .onErrorResume(error -> Mono.just(new Book(1, "Test", "kdkd",33)));

        bookMono.subscribe(book1 -> book.setAuthorId(book1.getAuthorId()+5678));*/

        System.out.println("Book processed successfully...");
        return book;
}
}
