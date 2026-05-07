package com.example.booksmanagementapp.service;

import com.example.booksmanagementapp.dto.BookRequestDTO;
import com.example.booksmanagementapp.dto.BookResponseDTO;
import com.example.booksmanagementapp.entity.Book;
import com.example.booksmanagementapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookService() {}

    public BookResponseDTO getBook(int id) {

        // Get the Entity (Book)
        Book book = bookRepository.findById(id).orElse(null);

        if (book == null) {
            return null;
        }

        // Create Response DTO
        BookResponseDTO dto = new BookResponseDTO();

        // Copy the Entity to DTO
        dto.setName(book.getName());

        // return DTO
        return dto;

    }

    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        return books.stream()
                .map(book -> {
                    BookResponseDTO dto = new BookResponseDTO();

                    dto.setName(book.getName());

                    return dto;
                })
                .toList();
    }

    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {

        // Create Entity
        Book book = new Book();

        // Copy DTO to Entity
        book.setName(bookRequestDTO.getName());

        // Save Entity into DB
        bookRepository.save(book);

        // Create Response DTO
        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        // Copy Entity Data into Response DTO
        bookResponseDTO.setName(book.getName());

        // Return DTO
        return bookResponseDTO;

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
