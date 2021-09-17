package com.example.services;

import com.example.models.Review;
import com.example.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends AbstractService<Review> {
    public ReviewService(ReviewRepository mainRepository){
        super(mainRepository);
    }
}
