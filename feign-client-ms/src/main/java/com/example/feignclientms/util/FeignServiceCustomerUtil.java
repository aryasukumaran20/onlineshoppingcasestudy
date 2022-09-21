package com.example.feignclientms.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "customer-ms", url = "http://localhost:4001/customers/")
public interface FeignServiceCustomerUtil {

    @GetMapping("/customers")
    String getCustId();
}
