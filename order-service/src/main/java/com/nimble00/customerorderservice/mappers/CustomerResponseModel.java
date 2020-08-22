package com.nimble00.customerorderservice.mappers;
import com.nimble00.customerorderservice.models.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseModel {
    private String fullName;
    private String address;
    private String email;
    private List<Order> orderList;
}
