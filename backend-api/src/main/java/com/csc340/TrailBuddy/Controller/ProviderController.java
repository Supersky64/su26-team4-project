package com.csc340.TrailBuddy.Controller;

import java.util.Collections;
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

import com.csc340.TrailBuddy.Entity.Provider;
import com.csc340.TrailBuddy.Service.ProviderService;

@RestController
@RequestMapping("api/providers")
public class ProviderController {
    
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        return providerService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = providerService.getAllProviders();
        if (providers.isEmpty()) {
        return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(providers);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Provider> getTrainerByEmail(@PathVariable String email) {
        Provider provider = providerService.findByEmail(email);
        if (provider != null) {
        return ResponseEntity.ok(provider);
        } else {
        return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/name")
    public ResponseEntity<List<Provider>> getProvidersByName(@RequestParam String query) {
        List<Provider> providers = providerService.findByName(query);
        if (providers.isEmpty()) {
        return ResponseEntity.ok(Collections.emptyList());
        }
        return ResponseEntity.ok(providers);
    }

    @PostMapping
    public ResponseEntity<Provider> createTrainer(@RequestBody Provider p) {
        Provider createdProvider = providerService.createProvider(p);
        return ResponseEntity.created(null).body(createdProvider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProviderInfo(@PathVariable Long id, @RequestBody Provider updatedProvider) {
        try {
            Provider p = providerService.updateProviderInfo(id, updatedProvider);
            return ResponseEntity.ok(p);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }

}