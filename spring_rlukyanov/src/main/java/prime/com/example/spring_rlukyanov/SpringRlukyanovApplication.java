package prime.com.example.spring_rlukyanov;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import prime.com.example.spring_rlukyanov.controller.CatController;
import prime.com.example.spring_rlukyanov.dblearn.test.CatSelect;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.service.BookService;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.service.impl.CatServiceImpl;
import prime.com.example.spring_rlukyanov.transactional.SimpleTransational;
import prime.com.example.spring_rlukyanov.exception.MyException;

@SpringBootApplication
// @Configurable Не понял как работает
public class SpringRlukyanovApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringRlukyanovApplication.class, args);
		CatSelect catSelector = applicationContext.getBean(CatSelect.class);
		String catName = catSelector.getCatNameById(2L);
		List<Cat> cats = catSelector.getAllCats();
	}
}