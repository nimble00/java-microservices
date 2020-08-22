package com.nimble00.customerorderservice.controllers;

import com.nimble00.customerorderservice.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nimble00.customerorderservice.mappers.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    OrderService orderService;

    // Instead of Autowire, this is done cuz it is resolved at compile
    // time. So, faster response.
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders/{customerId}")
    public ResponseEntity<OrderResponseModel> restOrderCreator(@PathVariable("customerId") String customerId, @RequestBody OrderRequestModel order) {
        return new ResponseEntity(orderService.createOrderByCustomerId(customerId,order),HttpStatus.ACCEPTED);
    }

    @GetMapping("/orders/{customerId}")
    public ResponseEntity<List<OrderResponseModel>> restOrderList(@PathVariable("customerId") String customerId) {
        List<OrderResponseModel> list = orderService.getAllOrdersById(customerId);
         return new ResponseEntity(list, HttpStatus.FOUND);
    }

    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseModel> addCustomer(@RequestBody CustomerRequestModel userRequestModel) {
        return new ResponseEntity<CustomerResponseModel>(orderService.addUser(userRequestModel), HttpStatus.CREATED);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<OrderResponseModel>> getAllUsers() {
        return new ResponseEntity(orderService.getAllCustomers(),HttpStatus.OK);
    }
}
// TEST USING POSTMAN

// URL for registration of a new customer: http://localhost:8081/api/customers/
// URL for placing of an order using customerId: http://localhost:8081/api/orders/{customerId}

// JSON object to create a customer (CustomerRequestModel)
//{
//        "fullName":"batman",
//        "address":"gotham",
//        "email":"imbatman@rich.com",
//        "password":"IronManSucks!"
//}

// JSON object to create an order (OrderRequestModel)
//{
//        "orderItems":"[alcohol, hot chicks etc]",
//        "deliveryAddress":"bruce wayne's villa, gotham",
//        "dateAndTime":"Date()",
//        "amount":"$1000",
//        "transactionId":"kj324hlkj1brjk134"
//}
