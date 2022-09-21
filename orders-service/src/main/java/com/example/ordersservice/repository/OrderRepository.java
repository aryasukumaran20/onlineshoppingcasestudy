package com.example.ordersservice.repository;

import com.example.ordersservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

    Order findByOrderId(String orderId);
}
