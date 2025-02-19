package prime.com.example.spring_rlukyanov.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prime.com.example.spring_rlukyanov.generics.InheritanceGeneric;

@RestController
@RequestMapping("/api/v1/generic")
public class GenericController {
    @GetMapping("/test")
    public ResponseEntity<Object> get() {
        String body = "";
        // Интерфейс списка
        List<Long> a1List = new ArrayList<Long>();
        // LinkedList — реализует интерфейс List. Является представителем
        // двунаправленного списка, где каждый элемент структуры содержит указатели на
        // предыдущий и следующий элементы.
        LinkedList<Object> a2List = new LinkedList<Object>();
        LinkedList<Long> a3List = new LinkedList<Long>();
        List<Number> a4List = new ArrayList<Number>();
        // ArrayList представляет собой реализацию интерфейса динамического массива
        ArrayList<Number> a45ist = new ArrayList<Number>();

        // a = new InheritanceGeneric<LinkedList<Object>>();
        InheritanceGeneric<List<Number>> a1;
        InheritanceGeneric<LinkedList<Number>> a2;
        InheritanceGeneric<ArrayList<Number>> a3;

        // a = new InheritanceGeneric<List<Number>>();
        // a = new InheritanceGeneric<ArrayList<Long>>();
        // a = new InheritanceGeneric<ArrayList<Number>>();

        return ResponseEntity.ok().body(body);
    }

}
