package com.example.controllers;

import com.example.models.OrderInfo;
import com.example.models.OrderInfo;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/")
    public ArrayList<OrderInfo> orders(){
        return orderService.findAll();
    }

    @GetMapping(value = "/{id}")
    public OrderInfo find(@PathVariable Long id){
        return orderService.get(id);
    }

    @PostMapping(value="/")
    public OrderInfo create(@RequestBody OrderInfo order){
        return orderService.create(order);
    }

    @PutMapping(value="/{id}")
    public OrderInfo update(@PathVariable Long id, @RequestBody OrderInfo order){
        order.setId(id);
        return orderService.update(order);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        orderService.delete(id);
        return new ResponseEntity<OrderInfo>(HttpStatus.NO_CONTENT);
    }
}
