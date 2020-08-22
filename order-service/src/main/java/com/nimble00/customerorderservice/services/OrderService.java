package com.nimble00.customerorderservice.services;

import com.nimble00.customerorderservice.mappers.CustomerRequestModel;
import com.nimble00.customerorderservice.mappers.CustomerResponseModel;
import com.nimble00.customerorderservice.mappers.OrderRequestModel;
import com.nimble00.customerorderservice.mappers.OrderResponseModel;
import com.nimble00.customerorderservice.models.Customer;
import com.nimble00.customerorderservice.models.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public interface OrderService {
    OrderResponseModel createOrderByCustomerId(String customerId, OrderRequestModel order);
    Optional<Customer> findByCustomerId(String customerId);
    CustomerResponseModel addUser(CustomerRequestModel userRequestModel);
    List<CustomerResponseModel> getAllCustomers();
    List<OrderResponseModel> getAllOrdersById(String customerId);
}
