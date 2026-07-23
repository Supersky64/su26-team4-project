package com.csc340.TrailBuddy.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc340.TrailBuddy.Service.CustomerService;
import com.csc340.TrailBuddy.Service.OutdoorServiceService;
import com.csc340.TrailBuddy.Service.ProviderService;
import com.csc340.TrailBuddy.Service.RSVPService;
import com.csc340.TrailBuddy.Service.ReviewService;

@Controller
@RequestMapping("/rsvp")
public class RSVPUiController {
    private final ProviderService providerService;
  private final OutdoorServiceService outdoorServiceService;
  private final ReviewService reviewService;
  private final CustomerService customerService;
  private final RSVPService rsvpService;

  public RSVPUiController(ProviderService providerService, OutdoorServiceService outdoorServiceService, ReviewService reviewService, CustomerService customerService, RSVPService rsvpService){
    this.providerService = providerService;
    this.outdoorServiceService = outdoorServiceService;
    this.reviewService = reviewService;
    this.customerService = customerService;
    this.rsvpService = rsvpService;
  }

  
}
