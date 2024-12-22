package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

@Service
public class ProductsServiceImpl implements ProductService {

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
