package com.csc340.TrailBuddy.Security;

import java.util.ArrayList;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Repository.CustomerRepository;
import com.csc340.TrailBuddy.Repository.ProviderRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;
    private final ProviderRepository providerRepository;

    public CustomUserDetailsService(CustomerRepository customerRepository, ProviderRepository providerRepository) {
        this.customerRepository = customerRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);

        if (customer != null) {
            return org.springframework.security.core.userdetails.User.withUsername(customer.getEmail())
                    .password(customer.getPassword()).roles("CUSTOMER").build();
        }

        Provider provider = providerRepository.findByEmailAddress(email);

        if (provider != null) {
            return org.springframework.security.core.userdetails.User.withUsername(provider.getEmailAddress())
                    .password(provider.getPassword()).roles("PROVIDER").build();
        }

        throw new UsernameNotFoundException("User Not Found!");
    }
}