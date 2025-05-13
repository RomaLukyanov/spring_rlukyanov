package prime.com.example.spring_rlukyanov.transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.model.enums.BreedCatEnum;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.repository.CatRepository;

@Component
public class PrepareStatementTransactional {
    @Autowired
    DataSource dataSource;
    @Autowired
    CatRepository repository;

    public void execUpdate(Connection connection, Map<Long, String> idToName) {
        String update = "insert into cat(id, name) values(?,?)";
        PreparedStatement prepareStatement;
        try {
            connection.setAutoCommit(false);
            prepareStatement = connection.prepareStatement(update);
            for (Long id : idToName.keySet()) {
                prepareStatement.setLong(1, id);
                prepareStatement.setString(2, idToName.get(id));
                prepareStatement.executeUpdate();
            }
            prepareStatement.close();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void execUpdateWithoutTransactional(Connection connection, Map<Long, String> idToName) {
        String update = "insert into cat(id, name) values(?,?)";
        PreparedStatement prepareStatement;
        try {
            prepareStatement = connection.prepareStatement(update);
            for (Long id : idToName.keySet()) {
                prepareStatement.setLong(1, id);
                prepareStatement.setString(2, idToName.get(id));
                prepareStatement.executeUpdate();
            }
            prepareStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateCats() {
        // Множество ключ значение
        Map<Long, String> set = new HashMap<>();
        set.put(7L, "cat_7");
        set.put(8L, "cat_8");
        try {
            this.execUpdateWithoutTransactional(dataSource.getConnection(), set);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateCatsWithRepository() {
        Cat cat = new Cat();
        cat.setName("cat_with_breed");
        BreedCatEnum breed = BreedCatEnum.getById(1);
        cat.setCatBreed(breed);
        repository.save(cat);
    }

}
