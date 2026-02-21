package com.example.productapi.repository;

import com.example.productapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    // Get all items by product id
    List<Item> findByProductId(Long productId);
}