package Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin(origins = "http://localhost:3000") // Allowing requests from React frontend
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Get all locations
    @GetMapping
    public ResponseEntity<List<Location>> getAllLocationsForUser() {
        List<Location> locations = locationService.getAllLocationsForUser(); // Adjust based on user-specific logic
        return ResponseEntity.ok(locations);
    }


    // Add a new location
    @PostMapping
    public ResponseEntity<String> addLocation(@RequestBody Location location) {
        try {
            locationService.addLocation(location);
            return ResponseEntity.ok("Location added successfully!");
        } catch (Exception e) {
            // Log exception (e.g., using a logger)
            return ResponseEntity.status(500).body("Failed to add location. Please try again.");
        }
    }

    // Update an existing location
    @PutMapping("/{id}")
    public ResponseEntity<String> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        Optional<Location> existingLocation = locationService.getLocationById(id);
        
        if (existingLocation.isPresent()) {
            Location updatedLocation = existingLocation.get();
            updatedLocation.setName(location.getName());
            updatedLocation.setDescription(location.getDescription());
            locationService.updateLocation(updatedLocation); // Update location instead of adding
            return ResponseEntity.ok("Location updated successfully!");
        } else {
            return ResponseEntity.status(404).body("Location not found.");
        }
    }
    


    // Delete a location
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        try {
            Optional<Location> location = locationService.getLocationById(id);
            if (location.isPresent()) {
                locationService.deleteLocation(id); // Delete the location
                return ResponseEntity.ok("Location deleted successfully!");
            } else {
                return ResponseEntity.status(404).body("Location not found.");
            }
        } catch (Exception e) {
            // Log exception (e.g., using a logger)
            return ResponseEntity.status(500).body("Failed to delete location. Please try again.");
        }
    }
}
