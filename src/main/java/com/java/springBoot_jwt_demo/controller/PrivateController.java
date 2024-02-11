package com.java.springBoot_jwt_demo.controller;

import com.java.springBoot_jwt_demo.entity.User;
import com.java.springBoot_jwt_demo.serviceInterface.ServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/private")
public class PrivateController {

    @Autowired
    private ServiceIntf service;


    @GetMapping(value = "/test")
    public String user(){
        return "Hello from Spring Boot";
    }
    @GetMapping(value="/users")
    public List<User> getAllUsers(){
        return service.getAllUser();
    }
    @GetMapping(value="/current-user")
    public String getCurrentLoggedInUser(Principal principal){
        //It will return the current Logged-In user name.
        return principal.getName();
    }


}
