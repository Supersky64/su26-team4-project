package com.csc340.TrailBuddy.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.TrailBuddy.Entity.RSVP;
import com.csc340.TrailBuddy.Service.RSVPService;

@RestController
@RequestMapping("/api/rsvp")
public class RSVPController {
    
    private final RSVPService rsvpService;

    public RSVPController (RSVPService rsvpService){
        this.rsvpService = rsvpService;
    }

    @PostMapping
    public ResponseEntity<RSVP> registerForOutdoorService(@RequestBody RSVP rsvp) {
        RSVP createdRSVP = rsvpService.createRegistration(rsvp);
        return ResponseEntity.ok(createdRSVP);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RSVP> getRSVPById(@PathVariable Long id) {
        RSVP rsvp = rsvpService.getRegistrationById(id);
        return ResponseEntity.ok(rsvp);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<RSVP>> getRegistrationByCustomer(@PathVariable Long customerId) {
        List<RSVP> rsvps = rsvpService.getRegistrationByCustomerId(customerId);
        return ResponseEntity.ok(rsvps);
    }
}
