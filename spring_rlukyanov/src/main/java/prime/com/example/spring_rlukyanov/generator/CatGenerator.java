package prime.com.example.spring_rlukyanov.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.model.enums.BreedCatEnum;
import prime.com.example.spring_rlukyanov.repository.CatRepository;

@Component
public class CatGenerator {
    @Autowired
    CatRepository repository;

    public void generateRandomCats(int numbOfCats) {
        Faker faker = new Faker();
        int minValue = 0;
        int maxValue = 6;
        int maxAgeValue = 20;
        while (numbOfCats > 0) {
            Cat cat = new Cat();
            String name = faker.name().firstName();
            numbOfCats--;
            cat.setName(name);
            int randomValue = minValue + (int) (Math.random() * (maxValue - minValue));
            int randomAge = minValue + (int) (Math.random() * (maxAgeValue - minValue));
            cat.setCatBreed(BreedCatEnum.getById(randomValue));
            cat.setAge(randomAge);
            repository.save(cat);
        }
    }
}
