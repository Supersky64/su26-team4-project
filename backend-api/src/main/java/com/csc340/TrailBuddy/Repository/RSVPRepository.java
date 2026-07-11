package com.csc340.TrailBuddy.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.csc340.TrailBuddy.Entity.RSVP;

@Repository
public interface RSVPRepository extends JpaRepository<RSVP, Long>{
  List<RSVP> findByCustomerId(Long customerID);
  List<RSVP> findByOutdoorServiceId(Long eventID);
  List<RSVP> findByOutdoorServiceProviderId(Long providerID);
}
