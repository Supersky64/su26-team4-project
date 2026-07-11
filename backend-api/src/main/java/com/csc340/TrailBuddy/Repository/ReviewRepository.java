package com.csc340.TrailBuddy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.TrailBuddy.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCustomer_CustomerId(Long customerId);
    //List<Review> findByProviderId(Long providerId);
}
