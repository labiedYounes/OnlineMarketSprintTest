package com.example.controllers;

import com.example.models.Category;
import com.example.models.Category;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/")
    public ArrayList<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Category find(@PathVariable Long id){
        return categoryService.get(id);
    }

    @PostMapping(value="/")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @PutMapping(value="/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        category.setId(id);
        return categoryService.update(category);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        categoryService.delete(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

}
