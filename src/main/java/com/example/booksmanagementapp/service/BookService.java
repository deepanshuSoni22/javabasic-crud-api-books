package com.example.booksmanagementapp.service;

import com.example.booksmanagementapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private int idCounter = 1;

    // Storage for books
    private List<Book> booksStorage = new ArrayList<>();

    public BookService() {}

    public Book getBook(int id) {
        for (Book book : booksStorage) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book) {
        book.setId(idCounter++);
        booksStorage.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return booksStorage;
    }

    public Book deleteBook(int id) {
        for (int i = 0; i < booksStorage.size(); i++) {
            Book book = booksStorage.get(i);
            if (book.getId() == id) {
                return booksStorage.remove(i);
            }
        }
        return null;
    }

    public Book updateBookName(int id, Book updatedBookName) {
        for (Book book : booksStorage) {
            if (book.getId() == id) {
                book.setName(updatedBookName.getName());
                return book;
            }
        }

        return null;
    }

}
