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
public class RSVP {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JsonIgnoreProperties({"rsvps"})
  @JoinColumn(nullable = false)
  private Customer customer;

  @ManyToOne
  @JsonIgnoreProperties({ "OutdoorServices" })
  @JoinColumn(nullable = false)
  private OutdoorService outdoorService;

  private String status;

  public RSVP(Customer customer, OutdoorService outdoorService, String status){
    this.customer = customer;
    this.outdoorService = outdoorService;
    this.status = status;
  }

}

