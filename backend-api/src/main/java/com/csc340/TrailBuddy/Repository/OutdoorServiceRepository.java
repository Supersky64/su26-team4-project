package com.csc340.TrailBuddy.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.csc340.TrailBuddy.Entity.OutdoorService;

@Repository
public interface OutdoorServiceRepository extends JpaRepository<OutdoorService, Long>{
  List<OutdoorService> findByProviderId(Long providerID);

  List<OutdoorService> findBySkillLevelContainingIgnoreCase(String skillLevel);

  List<OutdoorService> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String nameQuery, String descriptionQuery);
}
