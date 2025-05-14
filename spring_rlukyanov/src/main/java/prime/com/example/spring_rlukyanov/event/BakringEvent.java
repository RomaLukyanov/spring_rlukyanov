package prime.com.example.spring_rlukyanov.event;

import org.springframework.context.ApplicationEvent;

public class BakringEvent extends ApplicationEvent {
    private String message;

    public BakringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
