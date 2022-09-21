package com.example.ordersservice.controller;

import com.example.ordersservice.VO.ResponseTemplateVO;
import com.example.ordersservice.entity.Order;
import com.example.ordersservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getOrderWithProductCustomer(@PathVariable("id") String orderId){
        return orderService.getOrderWithProductCustomer(orderId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable("id") String orderId,@RequestBody Order order){
        return orderService.updateOrder(orderId,order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") String orderId){
        return orderService.deleteOrderById(orderId);
    }

}
