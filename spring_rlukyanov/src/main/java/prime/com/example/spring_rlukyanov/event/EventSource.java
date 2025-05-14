package prime.com.example.spring_rlukyanov.event;

import java.util.EventObject;
import java.util.LinkedList;
import java.util.List;

import prime.com.example.spring_rlukyanov.listener.CatEventListener;

public class EventSource {
    private static EventSource instance;
    private List<CatEventListener> listners = new LinkedList<CatEventListener>();

    private EventSource() {
    }

    public static EventSource getInstance() { // #3
        if (instance == null) { // если объект еще не создан
            instance = new EventSource(); // создать новый объект
        }
        return instance; // вернуть ранее созданный объект
    }

    public void addListener(CatEventListener listener) {
        listners.add(listener);
    }

    public void barkEvent() {
        EventObject somewhereBarking = new EventObject(this);
        for (CatEventListener listener : listners) {
            listener.handle(somewhereBarking);
        }
    }
}
