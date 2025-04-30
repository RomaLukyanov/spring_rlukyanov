package prime.com.example.spring_rlukyanov;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import prime.com.example.spring_rlukyanov.controller.CatController;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.service.BookService;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.service.impl.CatServiceImpl;
import prime.com.example.spring_rlukyanov.transactional.SimpleTransational;
import prime.com.example.spring_rlukyanov.exception.MyException;

@SpringBootApplication
//@Configurable Не понял как работает
public class SpringRlukyanovApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringRlukyanovApplication.class, args);
		//SimpleTransational simple = applicationContext.getBean(SimpleTransational.class);
		SimpleTransational simple = new SimpleTransational();
		simple.testTransactional();
	}
}