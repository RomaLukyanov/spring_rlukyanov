package prime.com.example.spring_rlukyanov.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import prime.com.example.spring_rlukyanov.model.Author;
import prime.com.example.spring_rlukyanov.service.AuthorService;

@RestController
@RequestMapping("/api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private AuthorService service;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Author author) {
        service.addAuthor(author);
        return ResponseEntity.ok().body("Successfully created");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        service.deleteAuthor(id);
        return ResponseEntity.ok().body("Successfully deleted");
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(service.getAuthor(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed");
        }
    }

    @GetMapping("/all")
    public List<Author> getAll() {
        return service.findAllAuthor();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Author author) {
        try {
            return ResponseEntity.ok().body(service.updateAuthor(author, id));
        } catch (Exception e) {
            return ResponseEntity.ok().body("Failed");
        }
    }

}
