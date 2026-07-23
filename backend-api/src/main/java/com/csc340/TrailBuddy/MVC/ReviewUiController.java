package com.csc340.TrailBuddy.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.csc340.TrailBuddy.Entity.Review;
import com.csc340.TrailBuddy.Service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewUiController {


    private final ReviewService reviewService;


    public ReviewUiController(ReviewService reviewService){
        this.reviewService = reviewService;
    }


    @GetMapping("/new/{providerId}")
public String showReviewForm(@PathVariable Long providerId, Model model) {
    model.addAttribute("review", new Review());
    model.addAttribute("providerId", providerId);
    return "reviews/review-form";
}


    @PostMapping("/create")
    public String createReview(Review review){
        reviewService.createReview(review);
        return "redirect:/services";
    }

}