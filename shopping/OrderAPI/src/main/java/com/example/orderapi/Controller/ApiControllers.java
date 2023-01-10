package com.example.orderapi.Controller;

import com.example.orderapi.Models.Order;
import com.example.orderapi.Payloads.requests.CreateOrderRequest;
import com.example.orderapi.Payloads.requests.UpdateOrderRequest;
import com.example.orderapi.Payloads.responses.ResponseOrder;
import com.example.orderapi.Services.ItemService;
import com.example.orderapi.Services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApiControllers {
    private ItemService itemService;
    private OrderService orderService;

    public ApiControllers(ItemService itemService, OrderService orderService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    private Logger logger = LoggerFactory.getLogger(ApiControllers.class);

    //create an item
    @PostMapping(value = "/addOrder")
    public ResponseEntity<ResponseOrder> addOrder(@RequestBody CreateOrderRequest request){
        ResponseOrder responseOrder = orderService.createOrder(request);
        return ResponseEntity.ok(responseOrder);
    }

    @PutMapping(value = "/updateOrder/{id}")
    public ResponseEntity<ResponseOrder> updateOrder(@PathVariable Integer id, @RequestBody UpdateOrderRequest updateOrderRequest){
        ResponseOrder responseOrder = orderService.updateOrder(id, updateOrderRequest);
        return ResponseEntity.ok(responseOrder);
    }

}
