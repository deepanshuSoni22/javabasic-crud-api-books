package com.example.booksmanagementapp.controller;

import com.example.booksmanagementapp.dto.BookRequestDTO;
import com.example.booksmanagementapp.dto.BookResponseDTO;
import com.example.booksmanagementapp.entity.Book;
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
    public BookResponseDTO getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    // get all books
    @GetMapping
    public List<BookResponseDTO> showBooks() {
        return bookService.getAllBooks();
    }

    // add a single book
    @PostMapping
    public BookResponseDTO addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        return bookService.addBook(bookRequestDTO);
    }

    // add bulk books
    @PostMapping("/bulk")
    public List<BookResponseDTO> addBooksInBulk(@RequestBody List<BookRequestDTO> books) {
        return books.stream()
            .map(bookService::addBook)
            .toList();
    }

    // delete a book
    @DeleteMapping("/delete/{id}")
    public BookResponseDTO deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }

    // update a book
    @PutMapping("/update/{id}")
    public BookResponseDTO updateBook(@PathVariable int id, @RequestBody BookRequestDTO updatedBookName) {
        return bookService.updateBookName(id, updatedBookName);
    }

}
