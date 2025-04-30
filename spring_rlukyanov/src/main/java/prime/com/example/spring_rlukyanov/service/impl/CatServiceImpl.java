package prime.com.example.spring_rlukyanov.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.model.BookLightest;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.repository.BookLightestRepository;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.repository.CatRepository;
import prime.com.example.spring_rlukyanov.service.BookService;
import prime.com.example.spring_rlukyanov.service.CatService;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatRepository repository;
    @Override
    public Cat getCat(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}