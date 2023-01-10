package com.example.orderapi.Services;

import com.example.orderapi.Models.Item;
import com.example.orderapi.Payloads.responses.ResponseItem;
import com.example.orderapi.Repo.ItemsRepository;
import com.example.orderapi.Repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    private ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

}
