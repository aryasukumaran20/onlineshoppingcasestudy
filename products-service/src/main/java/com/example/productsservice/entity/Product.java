package com.example.productsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "product")
public class Product {
    @Id
    private String productNo;
    private String productId;
    private String productName;
    private int productQty;
    private double productCost;
}
