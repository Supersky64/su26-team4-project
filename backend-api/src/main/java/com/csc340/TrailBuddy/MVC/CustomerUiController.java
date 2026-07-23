package com.csc340.TrailBuddy.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
public class CustomerUiController {

    private final CustomerService customerService;

    public CustomerUiController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/profile/{id}")
    public String getCustomerById(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id).orElse(null);

        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("pageTitle", "Hi, " + customer.getName());
            return "customer/customer-details";
        }

        return "customer-not-found";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("pageTitle", "Customer Sign Up");
        return "customer/customer-signup";
    }

    @PostMapping("/signup")
    public String createCustomer(Customer customer) {

        Customer savedCustomer = customerService.createCustomer(customer);

        return "redirect:/customer/profile/" + savedCustomer.getId();
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, Customer customer) {

        customerService.updatePersonalInfo(id, customer);

        return "redirect:/customer/profile/" + id;
    }
    
}