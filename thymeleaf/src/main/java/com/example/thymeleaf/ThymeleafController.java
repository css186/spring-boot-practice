package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/home")
    public String home(Model model) {

        Student student = new Student();
        student.setId(1);
        student.setName("John");

        model.addAttribute("myStudent", student);

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
