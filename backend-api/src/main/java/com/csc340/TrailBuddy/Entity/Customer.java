package com.csc340.TrailBuddy.Entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({"customerId", "name", "email", "password", "skillLevel", "preference"})


@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long customerId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  @Column(nullable = false)
  private String skillLevel;
  
  @Column(nullable = false)
  private String preference;

  public Customer(String name, String email, String password, String skillLevel, String preference) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.skillLevel = skillLevel;
    this.preference = preference;
  }


  @OneToMany(mappedBy = "customer")
  @JsonIgnoreProperties("customer")
  private java.util.List<Rsvp> rsvps;

   @OneToMany(mappedBy = "customer")
  @JsonIgnoreProperties("customer")
  private java.util.List<Review> reviews;
}
