package prime.com.example.spring_rlukyanov.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import prime.com.example.spring_rlukyanov.model.enums.BreedCatEnum;

@Data
@Entity

public class Cat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @Enumerated
    @Column(name = "breed_cat_id")
    private BreedCatEnum catBreed;
}
