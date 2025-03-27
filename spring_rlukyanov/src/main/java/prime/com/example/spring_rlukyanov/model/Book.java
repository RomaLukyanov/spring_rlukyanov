package prime.com.example.spring_rlukyanov.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_connections", joinColumns = @JoinColumn(name = "from_id"), inverseJoinColumns = @JoinColumn(name = "to_id"))
    private List<BookLightest> connectedTasks;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_connections", joinColumns = @JoinColumn(name = "to_id"), inverseJoinColumns = @JoinColumn(name = "from_id"))
    private List<BookLightest> inverseConnectedTasks;

}
