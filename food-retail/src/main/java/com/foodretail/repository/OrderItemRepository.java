package com.foodretail.repository;

import com.foodretail.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

    void deleteByProductId(int productId);
}