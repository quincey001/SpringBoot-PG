package com.example.orderapi.Services;

import com.example.orderapi.Repo.ItemsRepository;
import org.springframework.stereotype.Service;
@Service
public class ItemService {
    private ItemsRepository itemsRepository;

    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

}
