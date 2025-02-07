package prime.com.example.spring_rlukyanov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repository;

    @Override
    public Book addBook(Book book) {
        return repository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        repository.deleteById(id);

    }

    @Override
    public List<Book> findAllBook() {
        return repository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Book bookCurrent = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        bookCurrent.setName(book.getName());
        bookCurrent.setAuthors(book.getAuthors());
        return repository.save(bookCurrent);
    }

}
