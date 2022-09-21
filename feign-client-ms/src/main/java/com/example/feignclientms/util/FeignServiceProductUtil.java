package com.example.feignclientms.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "product-ms", url = "http://localhost:4000/products/")
public interface FeignServiceProductUtil {

    @GetMapping("/Products")
    String getProdId();
}
