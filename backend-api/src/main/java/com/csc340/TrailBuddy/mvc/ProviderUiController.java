package com.csc340.TrailBuddy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Service.CustomerService;
import com.csc340.TrailBuddy.Service.OutdoorServiceService;
import com.csc340.TrailBuddy.Service.ReviewService;

import jakarta.servlet.http.HttpSession;

import com.csc340.TrailBuddy.Service.ProviderService;
import com.csc340.TrailBuddy.Service.RSVPService;
    
@Controller
@RequestMapping("/provider")
public class ProviderUiController {

  private final ProviderService providerService;
  private final OutdoorServiceService outdoorServiceService;
  private final ReviewService reviewService;
  private final CustomerService customerService;
  private final RSVPService rsvpService;

  public ProviderUiController(ProviderService providerService, OutdoorServiceService outdoorServiceService, ReviewService reviewService,
     CustomerService customerService, RSVPService rsvpService){
    
        this.providerService = providerService;
        this.outdoorServiceService = outdoorServiceService;
        this.reviewService = reviewService;
        this.customerService = customerService;
        this.rsvpService = rsvpService;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String login(HttpSession session, String email, String password){
    Provider provider = providerService.findByEmailAddress(email);
    Customer customer = customerService.findByEmail(email);
    if (provider != null && password.equals(provider.getPassword())) {
      session.setAttribute("providerId", provider.getId());
      return "redirect:/provider/providerProfile";
    }else if(customer != null && password.equals(customer.getPassword())){
      session.setAttribute("customerId", customer.getId());
      return "redirect:/customer/customer";
    }

    return "redirect:/provider/login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/provider/login";
  }
  }
