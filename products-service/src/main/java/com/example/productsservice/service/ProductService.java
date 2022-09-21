package com.example.productsservice.service;

import com.example.productsservice.entity.Product;
import com.example.productsservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {


        this.productRepository = productRepository;
    }


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product getProductById(String productId) {
        List<Product> productList = getAllProducts();
        for(Product product : productList){
            if(product.getProductId().equals(productId)){
                return product;
            }
        }
        return null;
    }

    public ResponseEntity<HttpStatus> deleteProductById(String productId) {
        List<Product> productList = getAllProducts();
        for(Product product:productList){
            if(product.getProductId().equals(productId)){
                productRepository.delete(product);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public Product updateProductById(String productId, Product product) {
        Product _product = getProductById(productId);
        if(_product!=null){
            _product.setProductName(product.getProductName());
            _product.setProductQty(product.getProductQty());
            _product.setProductCost(product.getProductCost());
            productRepository.save(_product);
            return _product;
        }
        return null;
    }
}
