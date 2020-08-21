package com.nimble00.frontmicroservice.services;

import com.nimble00.frontmicroservice.models.Customer;

import java.util.Optional;

public interface CustomerService {

    Iterable<Customer> getAllCustomer();

    Optional<Customer> findById(String id);

    Customer findByName(String name);

    Customer addCustomer(Customer c);

    Optional<Customer> deleteCustomerById(String id);
}
