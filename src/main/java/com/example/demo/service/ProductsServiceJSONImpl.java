package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Primary
@Service("jsonResourceService")
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductsServiceJSONImpl implements ProductsService {
    public ProductsServiceJSONImpl() {
        System.out.println("JSON");
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products;
        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {
                            });
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
