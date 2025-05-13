package prime.com.example.spring_rlukyanov.specifiactionslearn;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.repository.CatRepository;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.service.impl.CatServiceImpl;

@Component
public class CatSearch {
    @Autowired
    CatRepository repository;
    @Autowired
    CatServiceImpl service;

    public Cat getById(Long id) {
        return  service.getCat(id);
    }
}
