package com.csc340.TrailBuddy.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.Review;
import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Entity.RSVP;

import com.csc340.TrailBuddy.Repository.ReviewRepository;
import com.csc340.TrailBuddy.Repository.ProviderRepository;
import com.csc340.TrailBuddy.Repository.RSVPRepository;


@Service
public class ProviderService {

  private final ReviewRepository reviewRepository;
  private final ProviderRepository providerRepository;
  private final RSVPRepository rsvpRepository;

  public ProviderService(ReviewRepository reviewRepository, ProviderRepository providerRepository, RSVPRepository rsvpRepository) {
    this.reviewRepository = reviewRepository;
    this.providerRepository = providerRepository;
    this.rsvpRepository = rsvpRepository;
  }

  public List<Provider> getAllProviders() {
    return providerRepository.findAll();
  }

  public Optional<Provider> findById(Long id) {
    return providerRepository.findById(id);
  }

  public Provider createProvider(Provider p) {
    return providerRepository.save(p);
  }

  public Provider updateProvider(Long id, Provider updatedProvider) {
    Optional<Provider> existingProvider = providerRepository.findById(id);
    if (existingProvider.isPresent()) {
      Provider provider = existingProvider.get();
      provider.setName(updatedProvider.getName());
      provider.setEmailAddress(updatedProvider.getEmailAddress());
      provider.setPassword(updatedProvider.getPassword());
      provider.setLocation(updatedProvider.getLocation());
      provider.setDescription(updatedProvider.getDescription());
      return providerRepository.save(provider);
    } else {
      throw new RuntimeException("Provider not found with ID: " + id);
    }
  }

  public Provider updateProviderInfo(Long id, Provider updatedProvider) {
    Optional<Provider> existingProvider = providerRepository.findById(id);
    if (existingProvider.isPresent()) {
      Provider p = existingProvider.get();
      if (updatedProvider.getName() != null) {
        p.setName(updatedProvider.getName());
      }
      if (updatedProvider.getEmailAddress() != null) {
        p.setEmailAddress(updatedProvider.getEmailAddress());
      }
      if (updatedProvider.getPassword() != null) {
        p.setPassword(updatedProvider.getPassword());
      }
      if (updatedProvider.getLocation() != null){
        p.setLocation(updatedProvider.getLocation());
      }
      p.setDescription(updatedProvider.getDescription());

      return providerRepository.save(p);
    } else {
      throw new RuntimeException("Trainer not found with ID: " + id);
    }
  }


  public void deleteProvider(Long id) {
    providerRepository.deleteById(id);
  }

  public Provider findByEmail(String email) {
    return providerRepository.findByEmailAddress(email);
  }

  public List<Provider> findByName(String name) {
    return providerRepository.findByNameContainingIgnoreCase(name);
  }

  
}
