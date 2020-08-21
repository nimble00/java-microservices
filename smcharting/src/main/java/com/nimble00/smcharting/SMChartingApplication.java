package com.nimble00.smcharting;

import com.nimble00.smcharting.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.nimble00.smcharting.repository")
@RestController
public class SMChartingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMChartingApplication.class, args);
//        SpringApplication.run(RouteController.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User userDto = new User(); // Dto means Data Transfer Object
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping("/companies")
    @ResponseBody
    public String companiesView() {
        return "Hello user. Here we'll serve a rest API endpoint for company view";
    }
}
