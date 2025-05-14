package prime.com.example.spring_rlukyanov.listener.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import prime.com.example.spring_rlukyanov.event.BakringEvent;
import prime.com.example.spring_rlukyanov.event.CatSource;
import prime.com.example.spring_rlukyanov.listener.CatEventListener;
import prime.com.example.spring_rlukyanov.model.Cat;

@Component
public class CatListener {
    @EventListener
    public void handleMBarkInSpring(BakringEvent event) {
        CatSource catSource = CatSource.getInstance();
        for (Cat cat : catSource.getLiveCats()) {
            System.out.println(cat.getName() + " услышал лай и убежал от спринга");
        }
    }
}
