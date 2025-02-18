package prime.com.example.spring_rlukyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prime.com.example.spring_rlukyanov.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
