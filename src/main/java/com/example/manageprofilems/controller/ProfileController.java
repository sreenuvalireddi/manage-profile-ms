package com.example.manageprofilems.controller;

import com.example.manageprofilems.model.Profile;
import com.example.manageprofilems.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    // Get all profiles
    @GetMapping
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileService.getAllProfiles());
    }

    // Get profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create profile
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(profileService.createProfile(profile));
    }

    // Update profile
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        try {
            return ResponseEntity.ok(profileService.updateProfile(id, profile));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }

    // Get active profiles
    @GetMapping("/active/list")
    public ResponseEntity<List<Profile>> getActiveProfiles() {
        return ResponseEntity.ok(profileService.getActiveProfiles());
    }

    // Search profiles
    @GetMapping("/search")
    public ResponseEntity<List<Profile>> searchProfiles(@RequestParam String name) {
        return ResponseEntity.ok(profileService.searchProfiles(name));
    }
}
