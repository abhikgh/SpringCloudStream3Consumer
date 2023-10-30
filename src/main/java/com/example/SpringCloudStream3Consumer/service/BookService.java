package com.example.SpringCloudStream3Consumer.service;

import com.example.SpringCloudStream3Consumer.model.Book;
import com.example.SpringCloudStream3Consumer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book updateBook(Book book) {
        book.setBookName(book.getBookName().toUpperCase());
        book.setBookIsbn(bookRepository.getReferenceById(book.getId()).getBookIsbn());
        System.out.println("Book processed successfully...");
        return book;
    }
}
