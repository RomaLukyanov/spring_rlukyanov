package prime.com.example.spring_rlukyanov.specification;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.metamodel.SingularAttribute;
import prime.com.example.spring_rlukyanov.model.Cat;

public class CatSpecification {

    public static Specification<Cat> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Cat> hasSeveralNames(List<String> names) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.disjunction(); // OR
            for (String name : names) {
                predicate = criteriaBuilder.or(predicate,
                        criteriaBuilder.equal(root.get("name"), name));
            }
            return predicate;
        };
    }

    // Для поиска по части строки (например, содержит)
    public static Specification<Cat> nameContains(String substring) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + substring + "%");
    }

    public static Specification<Cat> isLongTermCustomer() {
        return null;
      }
}
