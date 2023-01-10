package com.example.orderapi.Services;

import com.example.orderapi.Exception.ResourceNotFoundException;
import com.example.orderapi.Models.Item;
import com.example.orderapi.Models.Order;
import com.example.orderapi.Payloads.requests.CreateOrderRequest;
import com.example.orderapi.Payloads.requests.UpdateOrderRequest;
import com.example.orderapi.Payloads.responses.ResponseItem;
import com.example.orderapi.Payloads.responses.ResponseOrder;
import com.example.orderapi.Repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    //get response items for response order
    public List<ResponseItem> getResponseItems(List<Item> itemList){
        List<ResponseItem> responseItemList = new ArrayList<>();
        for(Item item : itemList){
            ResponseItem responseItem = new ResponseItem();
            responseItem.setName(item.getName());
            responseItem.setUnitPrice(item.getUnitPrice());
            responseItem.setQuantity(item.getQuantity());
            responseItemList.add(responseItem);
        }
        return responseItemList;
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    // get the total amount for the order
    public double getOrderAmount(List<Item> orderItem){
        double totalAmount = 0f;
        for(Item item : orderItem){
            totalAmount += item.getUnitPrice() * item.getQuantity();
        }
        return totalAmount;
    }
    //get response
    public ResponseOrder getResponseOrder(Order order){
        ResponseOrder responseOrder = new ResponseOrder();
        responseOrder.setId(order.getId());
        responseOrder.setTotalAmount(order.getTotalAmount());
        responseOrder.setItems(getResponseItems(order.getItems()));
        return responseOrder;
    }

    // create an order
    public ResponseOrder createOrder(CreateOrderRequest createOrderrequest){
        Order order = new Order(
                getOrderAmount(createOrderrequest.getItems()),
                createOrderrequest.getItems()
        );
        saveOrder(order);
        return getResponseOrder(order);
    }

    //update an order
    public ResponseOrder updateOrder(Integer orderId, UpdateOrderRequest updateOrderRequest)throws ResourceNotFoundException{
        Optional<Order> order1 = orderRepository.findById(updateOrderRequest.getId());

        if(order1.isEmpty()){
            throw new ResourceNotFoundException("Order","id",orderId);
        }else{
            double totalAmount = getOrderAmount(updateOrderRequest.getItems());
            order1.get().setTotalAmount(totalAmount);
            order1.get().setItems(updateOrderRequest.getItems());
            saveOrder(order1.get());
        }
        return getResponseOrder(order1.get());
    }


}
