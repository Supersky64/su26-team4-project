package com.csc340.TrailBuddy.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.TrailBuddy.Entity.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

  Provider findByEmailAddress(String email);    //to search by email

   List<Provider> findByNameContainingIgnoreCase(String name); //to find by name

}
