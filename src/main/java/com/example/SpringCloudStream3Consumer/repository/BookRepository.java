package com.example.SpringCloudStream3Consumer.repository;

import com.example.SpringCloudStream3Consumer.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
