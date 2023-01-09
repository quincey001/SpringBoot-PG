package com.example.ShoppingApp.Controller;

import com.example.ShoppingApp.Model.Customer;
import com.example.ShoppingApp.Model.Order;
import com.example.ShoppingApp.Model.Product;
import com.example.ShoppingApp.Util.OrderDTO;
import com.example.ShoppingApp.Util.ResponseOrder;
import com.example.ShoppingApp.Service.CustomerService;
import com.example.ShoppingApp.Service.OrderService;
import com.example.ShoppingApp.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class ApiControllers {
    private OrderService orderService;
    private ProductService productService;
    private CustomerService customerService;

    public ApiControllers(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    private Logger logger = LoggerFactory.getLogger(ApiControllers.class);

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }
    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<Order> getOrderDetail(@PathVariable int orderId){
        Order order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }
    @PostMapping(value = "/placeOrder")
    public ResponseEntity<ResponseOrder> placeOrder(@RequestBody OrderDTO orderDTO){
        logger.info("Request Payload" + orderDTO.toString());
        ResponseOrder responseOrder = new ResponseOrder();
        float amount = orderService.getCartAmount(orderDTO.getCartItems());
        // check if the customer exist in the database
        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
        Integer customerIdFromDb = customerService.isCustomerPresent(customer);

        if(customerIdFromDb != null){
            customer.setId(customerIdFromDb);
            logger.info("customer already present in db with id : "+ customerIdFromDb);
        }else{
            customer = customerService.saveCustomer(customer);
            logger.info("customer saved with id :" + customer.getId());
        }
        Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
        order = orderService.saveOrder(order);
        logger.info("order processed successfully...");

        responseOrder.setAmount(amount);
        responseOrder.setOrderId(order.getId());
        responseOrder.setInvoiceNumber(new Random().nextInt(1000));
        responseOrder.setOrderDescription(orderDTO.getOrderDescription());

        return ResponseEntity.ok(responseOrder);

    }

}
