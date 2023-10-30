package com.example.SpringCloudStream3Consumer.config;

import com.example.SpringCloudStream3Consumer.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;


import java.util.function.Consumer;

@Configuration
public class KafkaConfig {

    @Bean
    public Consumer<Book> consumer(){
       return book -> System.out.println("Consumed book.." + book.getId() + "-" + book.getBookName());
    }
}
