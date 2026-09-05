package com.foodretail.controller;

import com.foodretail.entity.Customer;
import com.foodretail.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public String customersPage(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/api/customers")
    @ResponseBody
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/api/customers")
    @ResponseBody
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/api/customers/{id}")
    @ResponseBody
    public Customer updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer) {

        customer.setId(id);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/api/customers/{id}")
    @ResponseBody
    public String deleteCustomer(@PathVariable int id) {

        customerService.deleteCustomer(id);

        return "Customer deleted successfully!";
    }
}