package com.nimble00.customerorderservice.mappers;

import com.nimble00.customerorderservice.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestModel {
    private String id;
    private String fullName;
    private String address;
    private String email;
    private String password;
    private List<Order> orderList;
}