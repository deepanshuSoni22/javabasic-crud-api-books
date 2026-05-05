package com.example.booksmanagementapp.controller;

import com.example.booksmanagementapp.model.Book;
import com.example.booksmanagementapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // show a book by id
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    // get all books
    @GetMapping
    public List<Book> showBooks() {
        return bookService.getAllBooks();
    }

    // add a single book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // add bulk books
    @PostMapping("/bulk")
    public List<Book> addBooksInBulk(@RequestBody List<Book> books) {
        return books.stream()
                .map(bookService::addBook)
                .toList();
    }

    // delete a book
    @DeleteMapping("/delete/{id}")
    public Book deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    // update a book
    @PutMapping("/update/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBookName) {
        return bookService.updateBookName(id, updatedBookName);
    }

}
