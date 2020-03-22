package com.bus.user.microservicespringuser.controller;

import com.bus.user.microservicespringuser.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieUserController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String testMethod(){
        User user = restTemplate.getForObject("http://localhost:7905/simple/1", User.class);
        return "this is spring user  test " + user.toString() ;
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
