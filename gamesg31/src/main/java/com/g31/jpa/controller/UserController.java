package com.g31.jpa.controller;

import com.g31.jpa.entity.User;
import com.g31.jpa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisOmar
 */
@RestController
@RequestMapping("/User")
//@CrossOrigin("*")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;
    
    
    @GetMapping("/all")
    public List<User> getUser(){
        return userService.getUser();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Integer idUser){
        return userService.getUserById(idUser);
    }
    
    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.status(201).build();
    }
    
    //Metodo para eliminar (Capa de controlador)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("Id") Integer id){
       userService.deleteUser(id);
       return ResponseEntity.status(204).build();
    }
    
    //Metodo para actualizar (Capa de controlador)
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody User user){
       userService.updateUser(user);
       return ResponseEntity.status(201).build(); 
    }
}
