package com.rafael.curso.springboot.webapp.controllers;

import com.rafael.curso.springboot.webapp.models.dto.ParamDto;
import com.rafael.curso.springboot.webapp.models.dto.ParamDtoMix;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hola que tal",
            name = "message") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamDtoMix bar(@RequestParam String text, @RequestParam Integer code) {
        ParamDtoMix params = new ParamDtoMix();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamDtoMix request(HttpServletRequest request) {
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        } catch (NumberFormatException e) {
        }
        ParamDtoMix params = new ParamDtoMix();
        params.setMessage(request.getParameter("message"));
        params.setCode(code);
        return params;
    }
}
