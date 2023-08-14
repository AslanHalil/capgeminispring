package com.capgemini.capgeminispring.api.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customerList.add(customer));
        return customerList;
    }

    @GetMapping("/find/{id}")
    public Optional<Customer> findCustomerById(@PathVariable("id") UUID id) {
        return customerRepository.findById(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @DeleteMapping("/delete")
    public void deleteCourses() {
        customerRepository.deleteAll();
    }

}
