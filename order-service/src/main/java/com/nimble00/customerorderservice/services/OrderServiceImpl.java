package com.nimble00.customerorderservice.services;

import com.nimble00.customerorderservice.mappers.CustomerRequestModel;
import com.nimble00.customerorderservice.mappers.CustomerResponseModel;
import com.nimble00.customerorderservice.mappers.OrderRequestModel;
import com.nimble00.customerorderservice.mappers.OrderResponseModel;
import com.nimble00.customerorderservice.models.Customer;
import com.nimble00.customerorderservice.models.Order;
import com.nimble00.customerorderservice.repository.CustomerOrderRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

    CustomerOrderRepo customerOrderRepo;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(CustomerOrderRepo customerOrderRepo, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.customerOrderRepo = customerOrderRepo;
    }

    @Override
    @Transactional
    public OrderResponseModel createOrderByCustomerId(String customerId, OrderRequestModel order) {
        Optional<Customer> cust = customerOrderRepo.findById(customerId);
        String str = UUID.randomUUID().toString();
        order.setId(str);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Order order1 = modelMapper.map(order, Order.class);
        Customer cust1 = cust.get();
        cust1.createOrder(order1);
        customerOrderRepo.save(cust1);
        return modelMapper.map(order1,OrderResponseModel.class);
    }

    @Override
    @Transactional
    public List<OrderResponseModel> getAllOrdersById(String customerId) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<OrderResponseModel>>(){}.getType();
        Optional<Customer> cust = customerOrderRepo.findById(customerId);
        Customer cust1 = cust.get();
        List<OrderResponseModel> orderList = modelMapper.map(cust1.getOrderList(),listType);
        return orderList;
    }

    @Override
    @Transactional
    public Optional<Customer> findByCustomerId(String customerId) {
        return customerOrderRepo.findById(customerId);
    }



    @Override
    @Transactional
    public CustomerResponseModel addUser(CustomerRequestModel userRequestModel) {
        String str = UUID.randomUUID().toString();
        userRequestModel.setId(str);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Customer user = customerOrderRepo.save(mapper.map(userRequestModel,Customer.class));
        return mapper.map(user,CustomerResponseModel.class);
    }


    @Override
    @Transactional
    public List<CustomerResponseModel> getAllCustomers() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Type listType = new TypeToken<List<CustomerResponseModel>>(){}.getType();
        // Incoming list is getting converted to UserResponseModel JSON for response
        List<CustomerResponseModel> userList = modelMapper.map(customerOrderRepo.findAll(),listType);
        return userList;
    }
}
