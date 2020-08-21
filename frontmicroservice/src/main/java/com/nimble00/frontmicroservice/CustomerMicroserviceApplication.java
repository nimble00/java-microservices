package com.nimble00.frontmicroservice;

import com.nimble00.frontmicroservice.models.Customer;
import com.nimble00.frontmicroservice.repository.CustomerDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.UUID;

@SpringBootApplication
public class CustomerMicroserviceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMicroserviceApplication.class, args);
    }
    private CustomerDao customerDao;

    public CustomerMicroserviceApplication(CustomerDao customerDao) {
        super();
        this.customerDao = customerDao;
    }

    @Override
    public void run(String... args) throws Exception {
        customerDao.save(new Customer(UUID.randomUUID().toString(),"John Doe",200000));
        customerDao.save(new Customer(UUID.randomUUID().toString(),"Marry Public",120000));
        customerDao.save(new Customer(UUID.randomUUID().toString(),"Demo Name",70000));

    }
}
