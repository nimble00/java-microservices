package com.nimble00.userservice.controllers;

import com.nimble00.userservice.exceptions.UserNotFoundException;
import com.nimble00.userservice.models.UserRequestModel;
import com.nimble00.userservice.models.UserResponseModel;
import com.nimble00.userservice.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    // Instead of Autowire, this is done cuz it is resolved at compile
    // time. So, faster response.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseModel> addUser(@RequestBody UserRequestModel userRequestModel) {
        return new ResponseEntity<UserResponseModel>(userService.addUser(userRequestModel), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseModel>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/users/{username}")
    public ResponseEntity<UserResponseModel> getUserByFullname(@PathVariable("username") String userName) throws UserNotFoundException {
        UserResponseModel user = userService.findUserByName(userName);
        if (user==null) {
            throw new UserNotFoundException("user not found with id " + userName);
        }
        return new ResponseEntity(userService.findUserByName(userName),HttpStatus.FOUND);
    }

}
