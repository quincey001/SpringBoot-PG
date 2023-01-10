package com.example.orderapi.Payloads.requests;

import com.example.orderapi.Models.Item;
import com.example.orderapi.Payloads.responses.ResponseItem;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
public class CreateOrderRequest {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public CreateOrderRequest(){

    }

}
