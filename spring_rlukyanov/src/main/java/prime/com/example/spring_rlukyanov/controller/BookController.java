package prime.com.example.spring_rlukyanov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.service.BookService;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Book book) {
        service.addBook(book);
        return ResponseEntity.ok().body("Successfully created");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.deleteBook(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(service.getBook(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return service.findAllBook();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Book book) {
        try {
            return ResponseEntity.ok().body(service.updateBook(book, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

}
