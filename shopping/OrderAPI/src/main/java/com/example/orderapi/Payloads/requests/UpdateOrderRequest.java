package com.example.orderapi.Payloads.requests;

import com.example.orderapi.Models.Item;
import com.example.orderapi.Payloads.responses.ResponseItem;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.List;
@SuperBuilder
public class UpdateOrderRequest {
    private int id;
    private List<Item> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public UpdateOrderRequest(){

    }
}
