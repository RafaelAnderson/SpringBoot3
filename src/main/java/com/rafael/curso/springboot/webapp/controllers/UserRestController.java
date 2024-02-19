package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.User;
import com.rafael.curso.springboot.webapp.models.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//@Controller
@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/details")
    //@ResponseBody
    public UserDto details() { // Patrón de inyección de dependencia
        UserDto userDto = new UserDto();
        User user = new User("Rafael", "Ponte");
        userDto.setTitle("Hola Mundo Spring Boot :)");
        userDto.setUser(user);
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user1 = new User("Rafael", "Ponte");
        User user2 = new User("Anderson", "Ponte");
        User user3 = new User("Amy", "Ponte");

        List<User> users = Arrays.asList(user1, user2, user3); // Clase helper
        //List<User> users = new ArrayList<>();
        //users.add(user1);
        //users.add(user2);
        //users.add(user3);

        return users;
    }

    @GetMapping("/detailsMap")
    //@ResponseBody
    public Map<String, Object> detailsMap() { // Patrón de inyección de dependencia
        User user = new User("Rafael", "Ponte");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }
}
