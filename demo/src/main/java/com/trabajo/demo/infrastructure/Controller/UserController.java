package com.trabajo.demo.infrastructure.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.trabajo.demo.application.service.UserService;
import com.trabajo.demo.domain.User;
import com.trabajo.demo.domain.dto.UserRequest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/user")
    public ResponseEntity<String> createNewUser(@RequestBody UserRequest userRequest) {
        boolean created = userService.newUser(userRequest);
        if (created) {
            return ResponseEntity.created(null).body("Usuario creado con exito");
        } else {
            return ResponseEntity.badRequest().body("Error al crear el usuario");
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> udateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        userRequest.setId(id);
        User user = userService.updateUserById(userRequest);
        
        return ResponseEntity.ok().body(user);
    }
    
    
    
}
