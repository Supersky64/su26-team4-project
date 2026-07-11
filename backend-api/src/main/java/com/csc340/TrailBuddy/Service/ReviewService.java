package com.csc340.TrailBuddy.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Entity.Review;
import com.csc340.TrailBuddy.Repository.CustomerRepository;
import com.csc340.TrailBuddy.Repository.ReviewRepository;

@Service
public class ReviewService {
    
    private final ReviewRepository reviewRepository;
    private final CustomerRepository customerRepository;

    public ReviewService(ReviewRepository reviewRepository, CustomerRepository customerRepository) {
        this.reviewRepository = reviewRepository;
        this.customerRepository = customerRepository;
    }


    public List<Review> getReviewsByCustomerId(Long customerId) {
        return reviewRepository.findByCustomer_CustomerId(customerId);
    }

    public List<Review> getReviewsByProviderId(Long providerId) {
        return reviewRepository.findByProviderId(providerId);
    }

    public Review createReview(Review review) {
        Long customerId = review.getCustomer().getCustomerId();

        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        review.setCustomer(customer); 

        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review review) {
        Review existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            if (review.getRating() != 0) {
                existingReview.setRating(review.getRating());
            }
            if (review.getComments() != null) {
                existingReview.setComments(review.getComments());
            }
            if (review.getReplyText() != null) {
                existingReview.setReplyText(review.getReplyText());
            }
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }
}
