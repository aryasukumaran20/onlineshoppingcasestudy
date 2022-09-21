package com.example.customerservice.repository;

import com.example.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends MongoRepository<Customer,String> {

}
