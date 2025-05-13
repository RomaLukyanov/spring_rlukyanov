package prime.com.example.spring_rlukyanov.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BreedCatEnum {

    CREATE(0, "Создается"),
    COORDINATION(1, "На согласовании начала выполнения"),
    PERFORMED(2, "Выполняется"),
    APPROVE(3, "На утверждении результата"),
    COMPLETED(4, "Завершена"),
    CANCELLED(5, "Создание отменено"),
    CLOSED(6, "Отменена");

    private Integer id;
    private String name;
    
    BreedCatEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public Integer getId() {
        return this.id;
    }

    @JsonCreator
    public static BreedCatEnum getById(int id) {
        for (BreedCatEnum e : values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
