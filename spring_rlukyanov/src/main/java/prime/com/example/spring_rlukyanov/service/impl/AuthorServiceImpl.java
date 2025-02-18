package prime.com.example.spring_rlukyanov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import prime.com.example.spring_rlukyanov.model.Author;
import prime.com.example.spring_rlukyanov.repository.AuthorRepository;
import prime.com.example.spring_rlukyanov.service.AuthorService;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private final AuthorRepository repository;

    @Override
    public Author addAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Author> findAllAuthor() {
        return repository.findAll();
    }

    @Override
    public Author getAuthor(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Author updateAuthor(Author author, Long id) {
        Author authorCurrent = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorCurrent.setName(author.getName());
        authorCurrent.setBooks(author.getBooks());
        return repository.save(authorCurrent);
    }

}
