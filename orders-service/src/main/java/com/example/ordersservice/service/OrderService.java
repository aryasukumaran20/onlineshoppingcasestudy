package com.example.ordersservice.service;

import com.example.ordersservice.VO.Customer;
import com.example.ordersservice.VO.Product;
import com.example.ordersservice.VO.ResponseTemplateVO;
import com.example.ordersservice.entity.Order;
import com.example.ordersservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String orderId) {
        Optional<Order> orderData =  orderRepository.findById(orderId);
        if(orderData.isPresent()){
            return orderData.get();
        }
        return null;
    }

    public ResponseEntity<Order> updateOrder(String orderId, Order order) {
        Order _order = getOrderById(orderId);
        if(_order!=null){
            _order.setOrderNo(order.getOrderNo());
            _order.setOrderStatus(order.getOrderStatus());
            _order.setProductId(order.getProductId());
            _order.setCustomerId(order.getCustomerId());
            return new ResponseEntity<>(orderRepository.save(_order), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteOrderById(String orderId) {
        Order order = getOrderById(orderId);
        if(order!=null){
            orderRepository.delete(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseTemplateVO getOrderWithProductCustomer(String orderId) {
        Order order = null;
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Optional<Order> orderData = orderRepository.findById(orderId);
        if(orderData.isPresent()){
            order = orderData.get();
        }
        //System.out.println(order);
        Product product = restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+order.getProductId(),Product.class);
        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customer/"+order.getCustomerId(),Customer.class);
        vo.setOrder(order);
        vo.setProduct(product);
        vo.setCustomer(customer);
        return vo;
    }
}
