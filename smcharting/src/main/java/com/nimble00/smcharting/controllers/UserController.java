package com.nimble00.smcharting.controllers;

import com.nimble00.smcharting.models.User;
import com.nimble00.smcharting.repository.UserRepository;
import com.nimble00.smcharting.services.MyUserDetailsService;
import com.nimble00.smcharting.services.UserAlreadyExistException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository applicationUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }


    @PostMapping("/user/registration")
    public String registerUserAccount(
            @ModelAttribute("user") User userDto,
            HttpServletRequest request, Errors errors) {

        try {
            User registered = MyUserDetailsService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {

            return "An account for that username/email already exists.";

        }

        return "successfully added the new user";
    }


}