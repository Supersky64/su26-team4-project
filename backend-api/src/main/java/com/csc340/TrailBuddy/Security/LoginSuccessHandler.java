package com.csc340.TrailBuddy.Security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Service.CustomerService;
import com.csc340.TrailBuddy.Service.ProviderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final CustomerService customerService;
    private final ProviderService providerService;

    public LoginSuccessHandler(CustomerService customerService, ProviderService providerService) {
        this.customerService = customerService;
        this.providerService = providerService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
                
                String email = authentication.getName();

                for(GrantedAuthority authority : authentication.getAuthorities()){
                    
                    if (authority.getAuthority().equals("ROLE_CUSTOMER")) {
                        Customer customer = customerService.findByEmail(email);
                        response.sendRedirect("/customer/profile/" + customer.getId());
                        return;
                    }

                    if (authority.getAuthority().equals("ROLE_PROVIDER")) {
                        Provider provider = providerService.findByEmail(email);
                        response.sendRedirect("/provider/providerProfile/" + provider.getId());
                        return;
                    }
                }

                response.sendRedirect("/login");
    }
}