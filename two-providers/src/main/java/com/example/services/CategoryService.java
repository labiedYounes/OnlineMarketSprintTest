package com.example.services;

import com.example.models.Category;
import com.example.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category> {
    public CategoryService(CategoryRepository mainRepository){
        super(mainRepository);
    }
}
