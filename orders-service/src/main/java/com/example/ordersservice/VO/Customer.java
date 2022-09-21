package com.example.ordersservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    private String customerNumber;
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerCity;
    private String customerState;
    private String customerCountry;
}
