package com.example.controllers;

import com.example.models.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    /*@RequestMapping("/user")
    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal, HttpServletRequest request) {
        return principal;
    }*/

    @RequestMapping("/users")
    public ArrayList<User> users() {
        return userService.findAll();
    }
}
