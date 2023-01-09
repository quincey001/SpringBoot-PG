package com.example.ShoppingApp.Service;

import com.example.ShoppingApp.Model.Product;
import com.example.ShoppingApp.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return this.productRepository.findAll();
    }
}
