package prime.com.example.spring_rlukyanov.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prime.com.example.spring_rlukyanov.model.Book;
import prime.com.example.spring_rlukyanov.reflection.DemonstrateReflectionClass;

@RestController
@RequestMapping("/api/v1/reflection")
public class ReflectionController {
    @PostMapping("/demonstrate")
    public ResponseEntity<Object> create() {
        //Демонстрация метода invoke и установка приватных полей класса
        DemonstrateReflectionClass reflectionObj = new DemonstrateReflectionClass();
        try {
            Field field = reflectionObj.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(reflectionObj, (String) "new value");
            // Позволяет работать с приватными методами, круто?
            String name = (String) field.get(reflectionObj);
            Method method = reflectionObj.getClass().getDeclaredMethod("getPrivateString");
            method.setAccessible(true);
            String result = (String) method.invoke(reflectionObj);
            return ResponseEntity.ok().body(result + " " + name);
        } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Successfully work");
    }
    @PostMapping("/demonstrate1")
    public ResponseEntity<Object> demonstrate() throws IllegalAccessException, InvocationTargetException {
        DemonstrateReflectionClass reflectionObj = new DemonstrateReflectionClass();
        try {
            Method method = reflectionObj.getClass().getDeclaredMethod("getPrivateString", String.class);
            method.setAccessible(true);
            String result = (String) method.invoke(reflectionObj,  "test");
            return ResponseEntity.ok().body(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Successfully work");
    }
}
