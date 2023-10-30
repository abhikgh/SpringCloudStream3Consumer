package com.example.SpringCloudStream3Consumer.config;

import com.example.SpringCloudStream3Consumer.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class KafkaConfig {

    @Bean
    public Function<Flux<Book>, Flux<Book>> processor() {
        return bookFlux -> bookFlux.map(this::updateBook);
    }

    private Book updateBook(Book book) {
        book.setBookName(book.getBookName().toUpperCase());
        System.out.println("Book updated...");
        return book;
    }
}
