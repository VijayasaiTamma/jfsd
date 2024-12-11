package Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Add a new location
    public Location addLocation(Location location) {
        try {
            return locationRepository.save(location); // Save location to the database
        } catch (Exception e) {
            throw new RuntimeException("Failed to add location", e); // Handle any exceptions
        }
    }

    // Get all locations
    public List<Location> getAllLocations() {
        return locationRepository.findAll(); // Fetch all locations from the repository
    }
    
    public List<Location> getAllLocationsForUser() {
        // Here, you could apply logic to filter locations based on user roles, permissions, etc.
        return locationRepository.findAll();  // Assuming there’s no user-specific filtering needed
    }

    // Get a location by ID (optional, for future use)
    public Optional<Location> getLocationById(Long id) {
        return locationRepository.findById(id); // Returns an Optional<Location> that can be checked
    }

    // Delete a location by its ID
    public void deleteLocation(Long id) {
        Optional<Location> location = getLocationById(id);
        if (location.isPresent()) {
            locationRepository.deleteById(id); // Only delete if the location exists
        } else {
            throw new RuntimeException("Location not found with ID: " + id); // Handle non-existing location
        }
    }

    // Update a location
    public void updateLocation(Location location) {
        Optional<Location> existingLocation = locationRepository.findById(location.getId());
        if (existingLocation.isPresent()) {
            Location updatedLocation = existingLocation.get();
            updatedLocation.setName(location.getName());
            updatedLocation.setDescription(location.getDescription());
            // Save updated location to the repository
            locationRepository.save(updatedLocation);
        } else {
            throw new RuntimeException("Location not found");
        }
    }

}
