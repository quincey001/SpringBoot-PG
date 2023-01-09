package com.example.ShoppingApp.Util;

import com.example.ShoppingApp.Model.ShoppingCart;

import java.util.List;

public class OrderDTO {
    private String customerName;
    private String customerEmail;
    private String orderDescription;
    private List<ShoppingCart> cartItems;
    public OrderDTO(){

    }

    public OrderDTO(String customerName, String customerEmail, String orderDescription, List<ShoppingCart> cartItems) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderDescription = orderDescription;
        this.cartItems = cartItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }
}
