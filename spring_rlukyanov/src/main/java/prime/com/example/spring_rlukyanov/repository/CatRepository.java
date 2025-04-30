package prime.com.example.spring_rlukyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prime.com.example.spring_rlukyanov.model.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long>{
    
}
