package prime.com.example.spring_rlukyanov.service;

import java.util.List;

import prime.com.example.spring_rlukyanov.model.Book;

public interface BookService {
    Book getBook(Long id);

    List<Book> findAllBook();

    Book addBook(Book book);

    Book updateBook(Book book, Long id);

    void deleteBook(Long id);
}
