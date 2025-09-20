package com.bazangarcia.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTemp {
    @GetMapping("/test")
    public String test(){
        return "La aplicación funciona correctamente";
    }
}
