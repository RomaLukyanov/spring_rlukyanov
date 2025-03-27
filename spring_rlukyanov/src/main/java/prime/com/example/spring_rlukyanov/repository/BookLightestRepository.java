package prime.com.example.spring_rlukyanov.repository;

import org.springframework.stereotype.Repository;
import prime.com.example.spring_rlukyanov.model.BookLightest;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookLightestRepository extends JpaRepository<BookLightest, Long> {

}
