package com.example.controllers;

import com.example.models.User;
import com.example.models.User;
import com.example.services.UserService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /*@RequestMapping("/user")
    public OAuth2User user(@AuthenticationPrincipal OAuth2User principal, HttpServletRequest request) {
        return principal;
    }*/

    @GetMapping(value = "/")
    public ArrayList<User> users(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User find(@PathVariable Long id){
        return userService.get(id);
    }

    @PostMapping(value="/")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping(value="/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
}
