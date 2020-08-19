package com.nimble00.smcharting;

import com.nimble00.smcharting.controllers.RouteController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nimble00.smcharting.repository")
@RestController
public class SMChartingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMChartingApplication.class, args);
//        SpringApplication.run(RouteController.class, args);
    }

    @RequestMapping("/signup")
    @ResponseBody
    public String newUser() {
        return "Hello new user. Here we'll serve a rest API endpoint for registration";
    }

    @RequestMapping("/companies")
    @ResponseBody
    public String companiesView() {
        return "Hello user. Here we'll serve a rest API endpoint for company view";
    }
}
