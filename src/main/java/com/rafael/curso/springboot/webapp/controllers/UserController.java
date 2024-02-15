package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) { // Patrón de inyección de dependencia
        User user = new User("Rafael", "Ponte");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }
}
