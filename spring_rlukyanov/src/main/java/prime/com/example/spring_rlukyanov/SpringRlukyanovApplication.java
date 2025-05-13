package prime.com.example.spring_rlukyanov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import com.github.javafaker.Faker;

import prime.com.example.spring_rlukyanov.generator.CatGenerator;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.service.CatService;
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
		CatGenerator generator = applicationContext.getBean(CatGenerator.class);
		CatService service = applicationContext.getBean(CatService.class);
		// generator.generateRandomCats(10);
		// List<Cat> result = service.getCatsByName("Sonya");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Sonya");
		list.add("Zander");
		List<Cat> result = service.getCatsByNames(list);
		// Cat cat = catSearch.getById(552L);
		List<Cat> result2 = service.getCustom();
		for (Cat cat : result2) {
			System.out.println(cat.toString());
		}
		// classObj.generateRandomCat(5);
	}
}