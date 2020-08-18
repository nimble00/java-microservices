package com.nimble00.smcharting.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RouteController {

    @RequestMapping("/signup")
    @ResponseBody
    public String registerUser() {
        return "Hello new user. Here we'll serve a rest API endpoint for registration";
    }
}
