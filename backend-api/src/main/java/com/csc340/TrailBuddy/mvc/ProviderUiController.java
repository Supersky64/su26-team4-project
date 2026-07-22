package com.csc340.TrailBuddy.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Entity.OutdoorService;
import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Entity.Review;
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

  public ProviderUiController(ProviderService providerService, OutdoorServiceService outdoorServiceService,
      ReviewService reviewService,
      CustomerService customerService, RSVPService rsvpService) {

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
  public String login(HttpSession session, String email, String password) {
    Provider provider = providerService.findByEmail(email);
    if (provider != null && password.equals(provider.getPassword())) {
      session.setAttribute("providerId", provider.getId());
      return "redirect:/provider/providerProfile/" + provider.getId();
    }
    return "redirect:/provider/login";
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/provider/login";
  }

  @GetMapping("/providerProfile/{id}")
  public String getProviderById(@PathVariable Long id, Model model) {
    Provider provider = providerService.findById(id).orElse(null);

    if (provider != null) {
      model.addAttribute("provider", provider);
      return "provider/providerProfile";
    }

    return "login";
  }

  @PostMapping("/signup")
  public String createAccout(HttpSession session, String name, String password, String description, String location,
      String email) {
    System.out.println("this is running");
    Provider createdProvider = new Provider(name, email, password, location, description);
    providerService.createProvider(createdProvider);
    System.out.println(createdProvider.toString());
    session.setAttribute("providerId", createdProvider.getId());
    return "redirect:/provider/providerProfile";
  }

  @GetMapping("/signup")
  public String createAccountPage() {
    System.out.println("am here in signup get");
    return "providerSignup";
  }

  @PostMapping("/update/{id}")
  public String updateProvider(@PathVariable Long id, Provider provider) {

    providerService.updateProviderInfo(id, provider);

    return "redirect:/provider/providerProfile/" + id;
  }

}
