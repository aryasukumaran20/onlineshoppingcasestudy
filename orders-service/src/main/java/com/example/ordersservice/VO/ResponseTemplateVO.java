package com.example.ordersservice.VO;

import com.example.ordersservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseTemplateVO {
    private Order order;
    private Product product;
    private Customer customer;
}
