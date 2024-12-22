package com.example.demo.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Customer;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(1, "Cliente 1", "clilente1", "1234"),
            new Customer(2, "Cliente 2", "clilente2", "1234"),
            new Customer(3, "Cliente 3", "clilente3", "1234"),
            new Customer(4, "Cliente 4", "clilente4", "1234")));

    // Ambas opciones son correctas
    // @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }
    // public List<Customer> getCustomers() {
    // return customers;
    // }

    // @GetMapping("/{username}")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByUsername(@PathVariable String username) {
        // public Customer getCustomerByUsername(@PathVariable String username) {
        // Asi se hace un foreach en java
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return ResponseEntity.ok(c);
                // return c;
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
    }

    // @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(customer.getUsername())
                .toUri();
        // return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    // @PutMapping
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> putCustomers(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return ResponseEntity.noContent().build(); // 204
            }
        }
        return ResponseEntity.notFound().build(); // 404
    }

    // @DeleteMapping("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        for (Customer c : customers) {
            if (c.getID() == id) {
                customers.remove(c);
                return ResponseEntity.noContent().build(); // 204
            }
        }
        return ResponseEntity.notFound().build(); // 404
    }

    // @PatchMapping
    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer) {
        for (Customer c : customers) {
            if (c.getID() == customer.getID()) {
                if (customer.getName() != null) {
                    c.setName(customer.getName());
                }
                if (customer.getUsername() != null) {
                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword() != null) {
                    c.setPassword(customer.getPassword());
                }
                return ResponseEntity.ok("Cliente modificado exitosamente" + c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
    }

}
