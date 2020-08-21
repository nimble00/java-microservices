package com.nimble00.frontmicroservice.controllers;

import java.util.Optional;

import com.nimble00.frontmicroservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nimble00.frontmicroservice.models.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        return new ResponseEntity<Iterable<Customer>>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Optional<Customer>> findCustomerById(@PathVariable("customerId") String customerId) {
        return new ResponseEntity(customerService.findById(customerId), HttpStatus.FOUND);
    }

    @GetMapping("/customers/{name}")
    public ResponseEntity<Optional<Customer>> findCustomerByName(@PathVariable("name") String fullname) {
        return new ResponseEntity(customerService.findByName(fullname), HttpStatus.FOUND);
    }

    @PostMapping("customers/newUser")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity(customerService.addCustomer(newCustomer),HttpStatus.ACCEPTED);
    }
}

