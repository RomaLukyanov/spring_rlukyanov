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
        return repository.findAll(createSpecificationWithAnonymClass());
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
                //predicate1 = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("age"), 8));
                Predicate result = criteriaBuilder.or(predicateWilton, predicateAlene);
                return result;
            }
        };
        return specification1;
    }
}