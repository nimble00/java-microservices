package com.nimble00.frontmicroservice.services;

import com.nimble00.frontmicroservice.models.Customer;
import com.nimble00.frontmicroservice.repository.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerRepo){
        this.customerRepo=customerRepo;
    }


    @Override
    public Iterable<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        return customerRepo.findById(customerId);
    }

    @Override
    public Customer addCustomer(Customer newCustomer) {
        return customerRepo.save(newCustomer);
    }

    @Override
    public Optional<Customer> deleteCustomerById(String id) {
        Optional<Customer> c = customerRepo.findById(id);
        if (c.isPresent()) {
            customerRepo.deleteById(id);
        }
        return c;
    }

    @Override
    public Customer findByName(String name) {
        return customerRepo.findByFullName(name);
    }
}
