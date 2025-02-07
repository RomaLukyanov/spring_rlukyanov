package prime.com.example.spring_rlukyanov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import prime.com.example.spring_rlukyanov.model.Book;

@Repository
public interface BookRepository  extends JpaRepository<Book, Long>{

}
