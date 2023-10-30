package com.example.SpringCloudStream3Consumer.service;

import com.example.SpringCloudStream3Consumer.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    public Book updateBook(Book book){
        book.setBookName(book.getBookName().toUpperCase());
        return book;
    }
}
