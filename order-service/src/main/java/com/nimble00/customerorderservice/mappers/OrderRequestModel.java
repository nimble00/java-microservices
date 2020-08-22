package com.nimble00.customerorderservice.mappers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestModel {
    private String id;
    private String orderItems;
    private String deliveryAddress;
    private String dateAndTime;
    private String amount;
    private String transactionId;
}