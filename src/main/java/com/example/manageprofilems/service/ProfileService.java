package com.example.manageprofilems.service;

import com.example.manageprofilems.model.Profile;
import com.example.manageprofilems.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    // Get all profiles
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    // Get profile by ID
    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    // Create profile
    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    // Update profile
    public Profile updateProfile(Long id, Profile profileDetails) {
        return profileRepository.findById(id).map(profile -> {
            profile.setFirstName(profileDetails.getFirstName());
            profile.setLastName(profileDetails.getLastName());
            profile.setEmail(profileDetails.getEmail());
            profile.setPhone(profileDetails.getPhone());
            profile.setAddress(profileDetails.getAddress());
            profile.setCity(profileDetails.getCity());
            profile.setCountry(profileDetails.getCountry());
            profile.setActive(profileDetails.getActive());
            return profileRepository.save(profile);
        }).orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    // Delete profile
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    // Get active profiles
    public List<Profile> getActiveProfiles() {
        return profileRepository.findByActive("true");
    }

    // Search profiles by name
    public List<Profile> searchProfiles(String name) {
        return profileRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }
}
