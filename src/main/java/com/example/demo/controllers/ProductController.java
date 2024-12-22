package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductsService;
//import com.example.demo.service.ProductsServiceImpl;

@RestController
@RequestMapping("/productos")
public class ProductController {

    // --- Instancia de clase

    // Polimorfismo dinamico
    // ProductService productService = new ProductsServiceImpl();
    // private ProductService productService; - Composicion

    @Autowired
    private ProductsService productService; // Inyeccion de dependencias

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
