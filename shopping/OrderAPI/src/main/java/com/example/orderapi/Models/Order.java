package com.example.orderapi.Models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Order{
    @Id
    @GeneratedValue
    private int id;
    private long totalPrice;
    @OneToMany
    List<Items> orderItems;
    public Order(){

    }
    public Order(int id, long totalPrice, List<Items> orderItems){
        this.id = id;
        this.totalPrice = totalPrice;
        this.orderItems = orderItems;
        for(Items item : orderItems){
            this.totalPrice += item.getQuantity()*item.getQuantity();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice =  totalPrice;
    }

    public List<Items> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<Items> orderItems) {
        this.orderItems = orderItems;
    }
}
