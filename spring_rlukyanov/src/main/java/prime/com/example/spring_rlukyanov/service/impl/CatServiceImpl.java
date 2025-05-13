package prime.com.example.spring_rlukyanov.service.impl;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.model.BookLightest;
import prime.com.example.spring_rlukyanov.model.Cat;
import prime.com.example.spring_rlukyanov.model.enums.BreedCatEnum;
import prime.com.example.spring_rlukyanov.repository.BookLightestRepository;
import prime.com.example.spring_rlukyanov.repository.BookRepository;
import prime.com.example.spring_rlukyanov.repository.CatRepository;
import prime.com.example.spring_rlukyanov.service.BookService;
import prime.com.example.spring_rlukyanov.service.CatService;
import prime.com.example.spring_rlukyanov.specification.CatSpecification;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cat getCat(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Cat> getCatsByName(String name) {
        return repository.findAll(CatSpecification.hasName(name));
    }

    @Override
    public List<Cat> getCatsByNames(List names) {
        return repository.findAll(CatSpecification.hasSeveralNames(names));
    }

    public List<Cat> getCustom() {
        return repository.findAll(createSpecificationBreedName());
    }

    private Specification<Cat> createSpecificationWithAnonymClass() {
        // Specification<Cat> specification = Specification.where(null);
        // CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // CriteriaQuery<Cat> query = criteriaBuilder.createQuery(Cat.class);
        // Root<Cat> root = query.from(Cat.class);
        // Predicate predicate = criteriaBuilder.conjunction();
        // Predicate result = criteriaBuilder.and(predicate,
        // criteriaBuilder.equal(root.get("name"), "test"));
        String test = "Alene";
        Specification<Cat> specification1 = new Specification<Cat>() {
            @Override
            public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // predicate =
                // criteriaBuilder.or(predicate,criteriaBuilder.equal(root.get("name"), name));
                Predicate predicateWilton = criteriaBuilder.equal(root.get("name"), "Wilton");
                Predicate predicateAlene = criteriaBuilder.equal(root.get("name"), "Alene");
                predicateAlene = criteriaBuilder.or(predicateAlene, criteriaBuilder.equal(root.get("age"), 13));
                // predicate1 = criteriaBuilder.and(predicate,
                // criteriaBuilder.equal(root.get("age"), 8));
                Predicate result = criteriaBuilder.or(predicateWilton, predicateAlene);
                query.orderBy(criteriaBuilder.desc(root.get("catBreed")));
                return result;
            }
        };
        return specification1;
    }

    private Specification<Cat> createSpecificationBreed() {
        return new Specification<Cat>() {
            @Override
            public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate approve = criteriaBuilder.equal(root.get("catBreed"), BreedCatEnum.APPROVE);
                Predicate cancel = criteriaBuilder.equal(root.get("catBreed"), BreedCatEnum.CANCELLED);
                Predicate result = criteriaBuilder.not(criteriaBuilder.or(approve, cancel));
                return result;
            }
        };
    }
    private Specification<Cat> createSpecificationBreedName() {
        return new Specification<Cat>() {
            @Override
            public Predicate toPredicate(Root<Cat> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //Не работает 
                //Predicate result = criteriaBuilder.equal(root.get("catBreed").get("name"), "Выполняется");
                Predicate predicate = criteriaBuilder.conjunction();
                query.orderBy(
                    criteriaBuilder.desc(
                        criteriaBuilder.selectCase(root.get("catBreed").as(Integer.class))
                            .when(0, "Создается")
                            .when(1, "На согласовании начала выполнения")
                            .when(2, "Выполняется")
                            .when(3, "На утверждении результата")
                            .when(4, "Завершена")
                            .when(5, "Создание отменено")
                            .when(6, "Отменена")
                    )
                );
                return null;
            }
        };
    }
}