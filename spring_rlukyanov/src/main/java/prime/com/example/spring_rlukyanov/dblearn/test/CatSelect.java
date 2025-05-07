package prime.com.example.spring_rlukyanov.dblearn.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import prime.com.example.spring_rlukyanov.dblearn.THandlerInterface.TResultHandler;
import prime.com.example.spring_rlukyanov.dblearn.executor.TExecutor;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.repository.CatRepository;

@Component
public class CatSelect {
    @Autowired
    DataSource dataSource;
    @Autowired
    CatRepository repository;

    private String getCatName(Connection connection, Long id) throws SQLException {

        TExecutor exec = new TExecutor();
        String name = exec.execQuery(
                connection,
                String.format("select name from cat where id=%d", id),
                new TResultHandler<String>() {
                    public String handle(ResultSet resultSet) throws SQLException {
                        if (resultSet.next()) {
                            return resultSet.getString("name");
                        }
                        return null;

                    }
                });
        return name;
    }

    private String getCatNameLambdaExpresion(Connection connection, Long id) throws SQLException {
        TExecutor exec = new TExecutor();
        String name = exec.execQuery(
                connection,
                String.format("select name from cat where id=%d", id),
                resultSet -> {
                    if (resultSet.next()) {
                        return resultSet.getString("name");
                    }
                    return null;
                });
        return name;
    }

    private List getAllCats(Connection connection) throws SQLException {
        try {
            TExecutor exec = new TExecutor();
            List allCats = exec.execQuery(
                    connection,
                    String.format("select * from cat"),
                    new TResultHandler<List<Cat>>() {
                        public List<Cat> handle(ResultSet resultSet) throws SQLException {
                            ArrayList<Cat> result = new ArrayList<>();
                            while (resultSet.next()) {
                                Cat cat = new Cat();
                                cat.setName(resultSet.getString("name"));
                                cat.setId(resultSet.getLong("id"));
                                result.add(cat);
                            }
                            return result;

                        }
                    });
            return allCats;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void generateNewCat() {
        Cat cat = new Cat();
        cat.setName("test_cat");
        repository.save(cat);
    }

    public String getCatNameById(Long id) {
        try {
            Connection connection = dataSource.getConnection();
            String name = this.getCatNameLambdaExpresion(connection, id);
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cat> getAllCats() {
        try {
            Connection connection = dataSource.getConnection();
            List cats = this.getAllCats(connection);
            return cats;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
