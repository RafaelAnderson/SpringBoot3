package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.User;
import com.rafael.curso.springboot.webapp.models.dto.ParamDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product,
                                               @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // hacer alo con el usuario save en la bbdd
        user.setName(user.getName().toUpperCase());
        return user;
    }
}
