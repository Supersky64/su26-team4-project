package com.csc340.TrailBuddy.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.RSVP;
import com.csc340.TrailBuddy.Repository.RSVPRepository;

@Service
public class RSVPService {
    
  private final RSVPRepository rsvpRepository;

  public RSVPService(RSVPRepository rsvpRepository) {
   this.rsvpRepository = rsvpRepository;
  }

  public List<RSVP> getRegistrationByCustomerId(Long customerId) {
    return rsvpRepository.findByCustomerId(customerId);
   }

  public List<RSVP> getRegistrationByOutdoorServiceId(Long outdoorServiceId) {
    return rsvpRepository.findByOutdoorServiceId(outdoorServiceId);
  }

  public RSVP createRegistration(RSVP rsvp) {
    return rsvpRepository.save(rsvp);
  }

  public RSVP getRegistrationById(Long registrationId) {
    return rsvpRepository.findById(registrationId).orElse(null);
  }

  public RSVP updateRegistration(RSVP rsvp) {
    RSVP existingReg = rsvpRepository.findById(rsvp.getId()).orElse(null);
    if (existingReg != null) {
      existingReg.setCustomer(rsvp.getCustomer());
      existingReg.setOutdoorService(rsvp.getOutdoorService());
      existingReg.setStatus(rsvp.getStatus());
    }
    return rsvpRepository.save(rsvp);
  }

  public void deleteRSVP(Long id) {
    rsvpRepository.deleteById(id);
  }

  public RSVP cancelRegistration(Long id) {
    RSVP existingReg = rsvpRepository.findById(id).orElse(null);
    if (existingReg != null) {
      existingReg.setStatus("Cancelled");
      return rsvpRepository.save(existingReg);
    }
    return null;
  }
}
