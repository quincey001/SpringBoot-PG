package com.example.orderapi.Models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "myOder")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalAmount;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Item.class)
    List<Item> items;
    public Order(){

    }

    public Order(double totalAmount, List<Item> items) {
        this.totalAmount = totalAmount;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
