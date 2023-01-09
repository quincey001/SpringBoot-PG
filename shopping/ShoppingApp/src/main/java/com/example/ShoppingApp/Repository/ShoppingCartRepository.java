package com.example.ShoppingApp.Repository;

import com.example.ShoppingApp.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<Order, Integer> {
}
