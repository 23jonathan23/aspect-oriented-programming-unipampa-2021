package com.sales.online.games.salesonlinegames.Presentation.Controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import javax.validation.Valid;

import com.sales.online.games.salesonlinegames.Domain.Application.UserService;
import com.sales.online.games.salesonlinegames.Domain.Core.User;
import com.sales.online.games.salesonlinegames.Domain.Core.Request.CreateUserRequest;
import com.sales.online.games.salesonlinegames.Domain.Core.Response.UserResponse;

@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        var allUser = userService.getAll();
        
        var response = new ArrayList<UserResponse>();

        for(var user : allUser) {
            var userResponse = new UserResponse();
            
            BeanUtils.copyProperties(user, userResponse);

            response.add(userResponse);
        }

        return new ResponseEntity<>(response ,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable long userId) {
        var user = userService.findById(userId);

        if(user != null) {
            var response = new UserResponse();

            BeanUtils.copyProperties(user, response);

            return new ResponseEntity<>(response ,HttpStatus.OK);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest request) {
        var user = new User();
        
        BeanUtils.copyProperties(request, user);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable long userId) {
        var response = userService.deleteUser(userId);

        return response.isPresent()
            ? ResponseEntity.status(HttpStatus.OK).body("")
            : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
    }
}
