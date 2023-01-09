package com.example.ShoppingApp.Service;

import com.example.ShoppingApp.Model.Order;
import com.example.ShoppingApp.Model.Product;
import com.example.ShoppingApp.Model.ShoppingCart;
import com.example.ShoppingApp.Repository.OrderRepository;
import com.example.ShoppingApp.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order getOrderDetail(int orderId){
        Optional<Order> order = this.orderRepository.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public float getCartAmount(List<ShoppingCart> shoppingCartList){
        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        int availableQuantity = 0;

        for(ShoppingCart cart : shoppingCartList){
            int productId = cart.getProductId();
            Optional<Product> product = productRepository.findById(productId);
            if(product.isPresent()){
                Product p = product.get();
                // check if the product has available product to provide for the shopping cart
                if(p.getAvailableQuantity() < cart.getQuantity()){
                    singleCartAmount = p.getPrice() * p.getAvailableQuantity();
                    cart.setQuantity(p.getAvailableQuantity());
                }else{
                    singleCartAmount = cart.getQuantity() * p.getPrice();
                    availableQuantity = p.getAvailableQuantity() - cart.getQuantity();
                }
                totalCartAmount += singleCartAmount;
                p.setAvailableQuantity(availableQuantity);
                availableQuantity = 0;
                cart.setProductName(p.getName());
                cart.setAmount(singleCartAmount);
                productRepository.save(p);
            }
        }
        return totalCartAmount;
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
}
