package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service("listResourceSercice")
@ConditionalOnProperty(name = "service.products", havingValue = "list")
public class ProductsServiceImpl implements ProductsService {
    public ProductsServiceImpl() {
        System.out.println("Lista");
    }

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Producto 1", 10, 20.99),
            new Product(2, "Producto 2", 10, 20.99),
            new Product(3, "Producto 3", 10, 20.99),
            new Product(4, "Producto 4", 10, 20.99)));

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
