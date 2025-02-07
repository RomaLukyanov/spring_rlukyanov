package prime.com.example.spring_rlukyanov.service;

import java.util.List;

import prime.com.example.spring_rlukyanov.model.Author;

public interface AuthorService {
    Author getAuthor(Long id);

    List<Author> findAllAuthor();

    Author addAuthor(Author author);

    Author updateAuthor(Author author, Long id);

    void deleteAuthor(Long id);
}
