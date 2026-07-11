package com.csc340.TrailBuddy.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

@JsonPropertyOrder({
    "id",
    "customer",
    "rating",
    "comments",
    "replyText"
})

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
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonIgnoreProperties({ "reviews", "timeslots" })
    @JoinColumn(nullable = false)
    private Provider provider;

    private int rating;
    private String comments;
    private String replyText;

    public Review(Customer customer, Provider provider, int rating, String comments, String replyText) {
        this.customer = customer;
        this.rating = rating;
        this.comments = comments;
        this.replyText = replyText;
        this.provider = provider;
    }
}
