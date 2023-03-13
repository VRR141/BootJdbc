package com.example.bootwebjdbc.controller;

import com.example.bootwebjdbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/fetch-product")
    public ResponseEntity<String> getProductName(@RequestParam(name = "name") String name){
        return ResponseEntity.ok(orderService.getProductNameByCustomerName(name));
    }
}
