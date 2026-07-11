package com.csc340.TrailBuddy.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

@Entity
@Table(name = "providers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long providerID;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String emailAddress;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String location;

  private String description;

  public Provider(String name, String email, String password, String location, String description) {
    this.name = name;
    emailAddress = email;
    this.password = password;
    this.location = location;
    this.description = description;
  }


  
}
