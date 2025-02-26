package com.wipro.mobilestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.mobilestore.entity.Order;
import com.wipro.mobilestore.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public ResponseEntity<Order> placeOrder(@RequestParam("customerId") int customerId) {
        Order order = orderService.placeOrder(customerId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable int orderId) {
        Order order = orderService.getOrderDetails(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
