package prime.com.example.spring_rlukyanov.transactional;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prime.com.example.spring_rlukyanov.exception.MyException;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.service.BookService;

@Component
public class SimpleTransational {
    @Autowired
    DataSource dataSource;
    @Autowired
    BookRepository repository;

    public void testTransactional() {
        // DataSource dataSource = (DataSource)
        // applicationContext.getBean("dataSource");
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            try {
                connection.setAutoCommit(false); // (2)
                // BookRepository repository = applicationContext.getBean(BookRepository.class);
                Book book1 = new Book();
                book1.setName("test1");
                repository.save(book1);
                Book book2 = new Book();
                book2.setName("test2");
                repository.save(book2);
                if (true) {
                    throw new MyException("test");
                }
                System.out.println("test");
                connection.commit(); // (3)
            } catch (MyException e) {
                connection.rollback(); // (4)
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }

    }
}
