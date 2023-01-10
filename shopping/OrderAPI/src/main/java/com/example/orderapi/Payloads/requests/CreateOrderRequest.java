package com.example.orderapi.Payloads.requests;

import com.example.orderapi.Models.Item;
import com.example.orderapi.Payloads.responses.ResponseItem;

import java.util.List;

public class CreateOrderRequest {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
