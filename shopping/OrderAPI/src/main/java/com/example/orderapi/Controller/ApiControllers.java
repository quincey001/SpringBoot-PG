package com.example.orderapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {
//    private OrderService orderService;
//    private ItemsService itemsService;
//
//    public ApiControllers(OrderService orderService, ItemsService itemsService) {
//        this.orderService = orderService;
//        this.itemsService = itemsService;
//    }

    @GetMapping(value = "/")
    public String getOder(){
        return "welcome";
    }
}
