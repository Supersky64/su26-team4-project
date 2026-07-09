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
@Table(name = "rsvps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rsvp {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"rsvps"})
    @JoinColumn(nullable = false)
    private Customer customer;

    private String location;

    public Rsvp(Customer customer, String location) {
        this.customer = customer;
        this.location = location;
    }
}
