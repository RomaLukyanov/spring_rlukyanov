package prime.com.example.spring_rlukyanov.service;

import java.util.List;
import java.util.Map;

import prime.com.example.spring_rlukyanov.model.Cat;

public interface CatService {
    Cat getCat(Long id);

    List<Cat> getCatsByName(String name);

    List<Cat> getCatsByNames(List names);

    List<Cat> getCustom();
}
