package com.csc340.TrailBuddy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.TrailBuddy.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    List<Customer> findBySkillLevelContainingIgnoreCase(String skillLevel);
}
