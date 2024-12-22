package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Primary
@Service
public class ProductsServiceJSONImpl implements ProductsService {

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
