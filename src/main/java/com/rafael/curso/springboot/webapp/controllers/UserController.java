package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) { // Patrón de inyección de dependencia
        User user = new User("Rafael", "Ponte");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        user.setEmail("rafael@correo.com");
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        //model.addAttribute("users", usersModel());
        model.addAttribute("title", "Listado de usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(new User("Pepa", "Gonzales"),
                new User("Dua", "Lipa", "duaLipa@correo.pe"),
                new User("Cristiano", "Dos Santos"));
    }
}
