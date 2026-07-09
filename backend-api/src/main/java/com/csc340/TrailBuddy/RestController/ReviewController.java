package com.csc340.TrailBuddy.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.TrailBuddy.Entity.Review;
import com.csc340.TrailBuddy.Service.ReviewService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

/*
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }
*/

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Review>> getReviewsByCustomerId(@PathVariable Long customerId) {
        List<Review> reviews = reviewService.getReviewsByCustomerId(customerId);
        return ResponseEntity.ok(reviews);
    }
    
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return ResponseEntity.ok(createdReview);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        try {
            Review review = reviewService.updateReview(id, updatedReview);
            return ResponseEntity.ok(review);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
