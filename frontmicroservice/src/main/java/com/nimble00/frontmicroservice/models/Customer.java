package com.nimble00.frontmicroservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @Column(name = "id")
    private String customerId;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "balance")
    private double accountBalance;

}
