package com.nimble00.frontmicroservice.repository;
import com.nimble00.frontmicroservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends JpaRepository<Customer, String> {
    Customer findByFullName(String name);
}
