package com.nimble00.customerorderservice.repository;

import com.nimble00.customerorderservice.models.Customer;
import com.nimble00.customerorderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepo extends JpaRepository<Customer,String> {

}
