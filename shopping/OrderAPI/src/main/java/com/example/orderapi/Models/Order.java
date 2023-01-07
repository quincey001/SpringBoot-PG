package com.example.orderapi.Models;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Order{
    @Id
    private long id;
    private long totalPrice;

    @OneToMany
    List<Items> orderItems;
}
