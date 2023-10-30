package com.example.SpringCloudStream3Consumer.config;

import com.example.SpringCloudStream3Consumer.model.Book;
import com.example.SpringCloudStream3Consumer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Configuration
public class KafkaConfig {

    @Autowired
    private BookService bookService;

    @Bean
    public Function<Flux<Book>, Flux<Book>> processor() {
        return bookFlux -> bookFlux.map(bookService::updateBook);
    }

}
