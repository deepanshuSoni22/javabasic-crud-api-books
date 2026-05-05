package com.example.booksmanagementapp.service;

import com.example.booksmanagementapp.model.Book;
import com.example.booksmanagementapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private int idCounter = 1;

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookService() {}

    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.isEmpty() ? null : books;
    }

    public Book addBook(Book book) {
        book.setId(idCounter++);
        return bookRepository.save(book);
    }


    public Book deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.deleteById(book.getId());
        return book;
    }

    public Book updateBookName(int id, Book updatedBookName) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setName(updatedBookName.getName());
        bookRepository.save(book);
        return book;
    }

}
