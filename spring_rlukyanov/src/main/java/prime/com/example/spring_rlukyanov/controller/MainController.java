package prime.com.example.spring_rlukyanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        // Возвращает имя файла без расширения, который находится в папке static или
        // templates
        return "index";
    }
}
