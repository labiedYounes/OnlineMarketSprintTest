package com.example.services;

import com.example.models.OrderInfo;
import com.example.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<OrderInfo> {
    public OrderService(OrderRepository mainRepository){
        super(mainRepository);
    }
}
