package prime.com.example.spring_rlukyanov.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import prime.com.example.spring_rlukyanov.event.BakringEvent;

@Service
public class DogService {
    private final ApplicationEventPublisher publisher;

    @Autowired
    public DogService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void bark() {
        // Публикация события
        BakringEvent event = new BakringEvent(this, "Это тестовое событие");
        publisher.publishEvent(event);
    }
}
