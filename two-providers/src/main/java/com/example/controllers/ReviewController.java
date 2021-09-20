package com.example.controllers;

import com.example.models.Review;
import com.example.models.Review;
import com.example.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@GetMapping(value = "/")
	public ArrayList<Review> reviews(){
		return reviewService.findAll();
	}
	@GetMapping(value = "/{id]")
	public Review find(@PathVariable Long id){
		return reviewService.get(id);
	}

	@PostMapping(value="/")
	public Review create(@RequestBody Review review){
		return reviewService.create(review);
	}

	@PutMapping(value="/{id}")
	public Review update(@PathVariable Long id, @RequestBody Review review){
		review.setId(id);
		return reviewService.update(review);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		reviewService.delete(id);
		return new ResponseEntity<Review>(HttpStatus.NO_CONTENT);
	}
}
