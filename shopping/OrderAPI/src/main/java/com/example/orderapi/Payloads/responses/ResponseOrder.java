package com.example.orderapi.Payloads.responses;

import java.util.List;

public class ResponseOrder {
    private int id;
    private double totalAmount;
    private List<ResponseItem> items;

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

    public List<ResponseItem> getItems() {
        return items;
    }

    public void setItems(List<ResponseItem> items) {
        this.items = items;
    }
}
