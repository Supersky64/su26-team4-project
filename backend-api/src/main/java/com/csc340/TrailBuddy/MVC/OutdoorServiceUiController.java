package com.csc340.TrailBuddy.MVC;
//Hi its ya girl Kyra tired and sick again

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.csc340.TrailBuddy.Entity.OutdoorService;
import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Service.OutdoorServiceService;

@Controller
@RequestMapping("/services")
public class OutdoorServiceUiController {

    private final OutdoorServiceService outdoorServiceService;

    public OutdoorServiceUiController(OutdoorServiceService outdoorServiceService) {
        this.outdoorServiceService = outdoorServiceService;
    }

    @GetMapping
    public String getAllOutdoorServices(Model model) {
        model.addAttribute("services", outdoorServiceService.getAllOutdoorServices());
        model.addAttribute("pageTitle", "Choose an Activity");
        return "outdoorServices/outdoorService-list";
    }

    @GetMapping("/{id}")
    public String getOutdoorServiceById(@PathVariable Long id, Model model) {
        OutdoorService outdoorService = outdoorServiceService.getOutdoorServiceById(id);
        Provider p = outdoorService.getProvider();
        if (outdoorService != null && p != null) {
            model.addAttribute("outdoorService", outdoorService);
            model.addAttribute("providerName", p.getName());
            model.addAttribute("providerEmail", p.getEmailAddress());
            model.addAttribute("pageTitle", outdoorService.getName());
            System.out.println("this point was reached");
            return "outdoorServices/outdoorService-details";
        } else {
            return "outdoorServices/outdoorService-not-found";
        }
    }

    @GetMapping("/provider/{providerId}")
    public String getProviderOutdoorService(@PathVariable Long providerId, Model model) {
        model.addAttribute("offerings", outdoorServiceService.getOutdoorServicesByProviderId(providerId));
        model.addAttribute("pageTitle", "My Activites");
        return "provider/offeringProvider";
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
