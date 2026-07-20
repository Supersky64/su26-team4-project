package com.csc340.TrailBuddy.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.Customer;
import com.csc340.TrailBuddy.Repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setSkillLevel(updatedCustomer.getSkillLevel());
            customer.setPreference(updatedCustomer.getPreference());
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public Customer updatePersonalInfo(Long id, Customer updatedCustomer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            if (updatedCustomer.getName() != null) {
                customer.setName(updatedCustomer.getName());
            }
            if (updatedCustomer.getEmail() != null) {
                customer.setEmail(updatedCustomer.getEmail());
            }
            if (updatedCustomer.getSkillLevel() != null) {
                customer.setSkillLevel(updatedCustomer.getSkillLevel());
            }
            if (updatedCustomer.getPreference() != null) {
                customer.setPreference(updatedCustomer.getPreference());
            }
            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Customer not found with id: " + id);
        }
    }

    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public List<Customer> findBySkillLevel(String skillLevel) {
        return customerRepository.findBySkillLevelContainingIgnoreCase(skillLevel);
    }

}
