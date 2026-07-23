package com.csc340.TrailBuddy.MVC;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


  @GetMapping("/providerProfile/{id}")
  public String getProviderById(@PathVariable Long id, Model model, HttpSession session) {
    Provider provider = providerService.findById(id).orElse(null);

    if (provider != null) {
      session.setAttribute("providerId", provider.getId());
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
    return "provider/providerSignup";
  }

  @PostMapping("/update/{id}")
  public String updateProvider(@PathVariable Long id, Provider provider) {

    providerService.updateProviderInfo(id, provider);

    return "redirect:/provider/providerProfile/" + id;
  }

  @PostMapping("/createOffering")
  public String createOffering(HttpSession session, String name, String description, String location, String gearList, String date, String skillLevel){
    Long providerId = (Long) session.getAttribute("providerId");
    if(providerId == null){
      System.out.println("providerId is null");
        return "redirect:login";
    }
    Provider provider = providerService.findById(providerId).orElse(null);
    OutdoorService offering = new OutdoorService(provider, name, description, skillLevel, location, gearList, date);
    outdoorServiceService.createOutdoorService(offering);
    return "redirect:/provider/offeringProvider";
  }

  @GetMapping("/offeringProvider")
  public String getAllOfferings(Model model, HttpSession session) {
    Long providerId = (Long) session.getAttribute("providerId");
    Provider provider = providerService.findById(providerId).orElse(null);
        model.addAttribute("offerings", outdoorServiceService.getOutdoorServicesByProviderId(providerId));
        model.addAttribute("provider", provider);
        return "/provider/offeringProvider";
    }

  @GetMapping("/edit/{id}")
    public String editOutdoorService(@PathVariable Long id, Model model) {
        OutdoorService outdoorService = outdoorServiceService.getOutdoorServiceById(id);
        model.addAttribute("outdoorService", outdoorService);
        model.addAttribute("pageTitle", "Edit " + outdoorService.getName());
        return "provider/updateOffering";
    }

    @PostMapping("/edit/{id}")
    public String updateOutdoorService(@PathVariable Long id, OutdoorService updatedOutdoorService) {
       OutdoorService outdoorService = outdoorServiceService.updateOutdoorService(id, updatedOutdoorService);
        
        return "redirect:/services/provider/" + outdoorService.getProvider().getId();
    }
    
    @PostMapping("/delete/{id}")
    public String deleteOutdoorService(@PathVariable Long id) {
        OutdoorService outdoorService = outdoorServiceService.getOutdoorServiceById(id);
        Long providerId = outdoorService.getProvider().getId();
        outdoorServiceService.deleteOutdoorService(id);        
        return "redirect:/services/provider/" + providerId;
    }
}
