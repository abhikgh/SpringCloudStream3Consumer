package com.example.SpringCloudStream3Consumer.service;

import com.example.SpringCloudStream3Consumer.model.Book;
import com.example.SpringCloudStream3Consumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(Book book) {
        book.setBookName(book.getBookName().toUpperCase());
        bookRepository.findById(book.getId()).ifPresent(book1 -> {
            book.setBookIsbn(book1.getBookIsbn());
            book.setAuthorId(book1.getAuthorId());
         });
        System.out.println("Book processed successfully...");
        return book;
    }
}
