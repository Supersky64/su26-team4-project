package com.csc340.TrailBuddy.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csc340.TrailBuddy.Entity.OutdoorService;
import com.csc340.TrailBuddy.Service.OutdoorServiceService;

@RestController
@RequestMapping("/api/outdoor-services")
public class OutdoorServiceController {

    private OutdoorServiceService outdoorServiceService;

    public OutdoorServiceController(OutdoorServiceService outdoorServiceService){
        this.outdoorServiceService = outdoorServiceService;
    }

    @GetMapping
    public ResponseEntity<List<OutdoorService>> getAllOutdoorServices() {
        List<OutdoorService> outdoorServices = outdoorServiceService.getAllOutdoorServices();
        return ResponseEntity.ok(outdoorServices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutdoorService> getOutdoorServiceById(@PathVariable Long id) {
        OutdoorService outdoorService = outdoorServiceService.getOutdoorServiceById(id);
        if (outdoorService == null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(outdoorService);
    }

    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<OutdoorService>> getOutdoorServicesByProviderId(@PathVariable Long providerId) {
        List<OutdoorService> outdoorServices = outdoorServiceService.getOutdoorServicesByProviderId(providerId);
        return ResponseEntity.ok(outdoorServices);
    }

    @GetMapping("/skill-level/{skillLevel}")
    public ResponseEntity<List<OutdoorService>> getOutdoorServicesBySkillLevel(@PathVariable String skillLevel) {
        List<OutdoorService> outdoorServices = outdoorServiceService.getTrainingServicesBySkillLevel(skillLevel);
        return ResponseEntity.ok(outdoorServices);
    }

    @GetMapping("/search")
    public ResponseEntity<List<OutdoorService>> searchOutdoorServicesByName(@RequestParam String query) {
        List<OutdoorService> outdoorServices = outdoorServiceService.searchOutdoorServicesByName(query);
        return ResponseEntity.ok(outdoorServices);
    }

    @PostMapping
    public ResponseEntity<OutdoorService> createOutdoorService(@RequestBody OutdoorService outdoorService) {
        OutdoorService createdOutdoorService = outdoorServiceService.createOutdoorService(outdoorService);
        return ResponseEntity.ok(createdOutdoorService);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OutdoorService> updateOutdoorService(@PathVariable Long id, @RequestBody OutdoorService outdoorService) {
        OutdoorService updatedOutdoorService = outdoorServiceService.updateOutdoorService(id, outdoorService);
        if (updatedOutdoorService == null) {
        return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedOutdoorService);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteOutdoorService(@PathVariable Long id) {
        outdoorServiceService.deleteOutdoorService(id);
        return ResponseEntity.noContent().build();
    }

}
