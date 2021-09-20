package com.example.controllers;

import com.example.models.Product;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public ArrayList<Product> products(){
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product find(@PathVariable Long id){
        return productService.get(id);
    }

    @PostMapping(value="/")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping(value="/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id);
        return productService.update(product);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}
