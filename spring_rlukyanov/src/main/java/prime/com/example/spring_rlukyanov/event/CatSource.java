package prime.com.example.spring_rlukyanov.event;

import java.util.HashSet;
import java.util.LinkedHashSet;

import prime.com.example.spring_rlukyanov.model.Cat;

public class CatSource {
    private HashSet<Cat> liveCat = new LinkedHashSet<>();
    private static CatSource instance;

    private CatSource() {
    }

    public static CatSource getInstance() { // #3
        if (instance == null) { // если объект еще не создан
            instance = new CatSource(); // создать новый объект
        }
        return instance; // вернуть ранее созданный объект
    }

    public void addCat(Cat cat) {
        liveCat.add(cat);
    }

    public void removeCat(Cat cat) {
        liveCat.remove(cat);
    }

    public HashSet<Cat> getLiveCats() {
        return liveCat;
    }
}
