package com.example.booksmanagementapp.repository;

import com.example.booksmanagementapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
