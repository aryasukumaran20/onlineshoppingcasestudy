package com.example.feignclientms.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order-ms", url = "http://localhost:4002/orders/")
public interface FeignServiceOrderUtil {

    @GetMapping("/Orders")
    String getOrdId();
}
