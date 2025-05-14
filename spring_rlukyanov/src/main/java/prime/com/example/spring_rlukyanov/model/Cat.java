package prime.com.example.spring_rlukyanov.model;

import java.util.EventObject;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import lombok.Data;
import prime.com.example.spring_rlukyanov.event.BakringEvent;
import prime.com.example.spring_rlukyanov.event.CatSource;
import prime.com.example.spring_rlukyanov.listener.CatEventListener;
import prime.com.example.spring_rlukyanov.listener.model.CatListener;
import prime.com.example.spring_rlukyanov.model.enums.BreedCatEnum;

@Data
@Entity
public class Cat implements CatEventListener {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;

    @Enumerated
    @Column(name = "breed_cat_id")
    private BreedCatEnum catBreed;

    @PostPersist
    public void beforeSave() {
        System.out.println("Кот сохранен успешно " + this.name);
    }

    @Override
    public void handle(EventObject event) {
        System.out.println(this.name + " услышал лай и убежал");
    }

    @PostLoad
    public void afterLoad() {
        CatSource catSource = CatSource.getInstance();
        catSource.addCat(this);
        System.out.println("Родился " + this.name);
    }

    public void catRunAway() {
        CatSource catSource = CatSource.getInstance();
        catSource.removeCat(this);
    }
}
