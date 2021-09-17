package com.example.services;

import com.example.models.Product;
import com.example.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractService<Product> {
    public ProductService(ProductRepository mainRepository){
        super(mainRepository);
    }
}
