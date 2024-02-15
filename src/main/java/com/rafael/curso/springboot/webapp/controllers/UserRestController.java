package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/details2")
    //@ResponseBody
    public Map<String, Object> details() { // Patrón de inyección de dependencia
        User user = new User("Rafael", "Ponte");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
