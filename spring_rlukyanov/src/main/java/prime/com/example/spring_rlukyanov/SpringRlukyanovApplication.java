package prime.com.example.spring_rlukyanov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.github.javafaker.Faker;

import prime.com.example.spring_rlukyanov.event.EventSource;
import prime.com.example.spring_rlukyanov.generator.CatGenerator;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.service.impl.DogService;
import prime.com.example.spring_rlukyanov.specifiactionslearn.CatSearch;
import prime.com.example.spring_rlukyanov.specification.CatSpecification;
//import net.datafaker.Faker;
import prime.com.example.spring_rlukyanov.transactional.PrepareStatementTransactional;

@SpringBootApplication
// @Configurable Не понял как работает
public class SpringRlukyanovApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(SpringRlukyanovApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer() {
		return factory -> factory.setPort(8081);
	}
}