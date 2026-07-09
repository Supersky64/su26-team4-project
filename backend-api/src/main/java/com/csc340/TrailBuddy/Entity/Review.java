package com.csc340.TrailBuddy.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"reviews", "rsvps"})
    @JoinColumn(nullable = false)
    private Customer customer;

    private int rating;
    private String comments;
    private String replyText;

    public Review(Customer customer, int rating, String comments, String replyText) {
        this.customer = customer;
        this.rating = rating;
        this.comments = comments;
        this.replyText = replyText;
    }
}
