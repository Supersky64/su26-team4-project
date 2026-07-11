package com.csc340.TrailBuddy.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csc340.TrailBuddy.Entity.OutdoorService;
import com.csc340.TrailBuddy.Repository.OutdoorServiceRepository;

@Service
public class OutdoorServiceService {
  private final OutdoorServiceRepository outdoorServiceRepository;

  public OutdoorServiceService(OutdoorServiceRepository outdoorServiceRepository) {
    this.outdoorServiceRepository = outdoorServiceRepository;
  }

  public List<OutdoorService> getAllOutdoorServices() {
    return outdoorServiceRepository.findAll();
  }

  public OutdoorService getOutdoorServiceById(Long id) {
    return outdoorServiceRepository.findById(id).orElse(null);
  }

  public List<OutdoorService> getTrainingServicesBySkillLevel(String skillLevel) {
    return outdoorServiceRepository.findBySkillLevelContainingIgnoreCase(skillLevel);
  }

  public OutdoorService createOutdoorService(OutdoorService outdoorService) {
    return outdoorServiceRepository.save(outdoorService);
  }

  public List<OutdoorService> getOutdoorServicesByProviderId(Long providerId) {
    return outdoorServiceRepository.findByProviderId(providerId);
  }

  public OutdoorService updateOutdoorService(Long id, OutdoorService updatedOutdoorService) {
    return outdoorServiceRepository.findById(id).map(outdoorService -> {
          outdoorService.setName(updatedOutdoorService.getName());
          outdoorService.setDescription(updatedOutdoorService.getDescription());
          outdoorService.setSkillLevel(updatedOutdoorService.getSkillLevel());
          outdoorService.setLocation(updatedOutdoorService.getLocation());
          outdoorService.setGearList(updatedOutdoorService.getGearList());
          outdoorService.setDate(updatedOutdoorService.getDate());
          return outdoorServiceRepository.save(outdoorService);
        })
        .orElseThrow(() -> new RuntimeException("Outdoor service not found with id: " + id));
  }

  public void deleteOutdoorService(Long id) {
    outdoorServiceRepository.deleteById(id);
  }

  public List<OutdoorService> searchOutdoorServicesByName(String query) {
    return outdoorServiceRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query);
  }
}
