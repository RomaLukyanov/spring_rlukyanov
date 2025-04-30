package prime.com.example.spring_rlukyanov;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import prime.com.example.spring_rlukyanov.controller.CatController;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.service.BookService;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.service.impl.CatServiceImpl;

@SpringBootApplication
public class SpringRlukyanovApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringRlukyanovApplication.class, args);
		CatService bean = context.getBean(CatService.class);

		System.out.println("test");
	}

}