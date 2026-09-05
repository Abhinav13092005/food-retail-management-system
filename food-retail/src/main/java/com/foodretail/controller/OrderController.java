package com.foodretail.controller;

import com.foodretail.entity.Order;
import com.foodretail.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String ordersPage(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/api/orders")
    @ResponseBody
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/api/orders")
    @ResponseBody
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/api/orders/{id}")
    @ResponseBody
    public Order updateOrder(
            @PathVariable int id,
            @RequestBody Order order) {

        order.setId(id);
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/api/orders/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable int id) {

        orderService.deleteOrder(id);

        return "Order deleted successfully!";
    }
}