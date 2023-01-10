package com.example.orderapi.Repo;

import com.example.orderapi.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
