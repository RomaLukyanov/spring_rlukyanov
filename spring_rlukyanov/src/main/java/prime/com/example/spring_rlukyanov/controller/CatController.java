package prime.com.example.spring_rlukyanov.controller;

import org.springframework.beans.factory.annotation.Autowired;

import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.service.AuthorService;
import prime.com.example.spring_rlukyanov.service.CatService;

public class CatController {
    @Autowired
    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    public Cat getCat() {
        return service.getCat(1L);
    }
}
