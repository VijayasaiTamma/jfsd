package TourGuide;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourGuideService {

    @Autowired
    private TourGuideRepository tourGuideRepository;

    // Get all tour guides
    public List<TourGuide> getAllTourGuides() {
        return tourGuideRepository.findAll();
    }

    // Get tour guide by ID
    public Optional<TourGuide> getTourGuideById(Long id) {
        return tourGuideRepository.findById(id);
    }

    // Add a new tour guide
    public TourGuide addTourGuide(TourGuide tourGuide) {
        validateTourGuide(tourGuide); // Custom validation
        return tourGuideRepository.save(tourGuide);
    }

    // Delete a tour guide by ID
    public void deleteTourGuide(Long id) {
        if (!tourGuideRepository.existsById(id)) {
            throw new IllegalArgumentException("Tour Guide with ID " + id + " does not exist.");
        }
        tourGuideRepository.deleteById(id);
    }

    // Update a tour guide
    public TourGuide updateTourGuide(Long id, TourGuide updatedTourGuide) {
        if (!tourGuideRepository.existsById(id)) {
            throw new IllegalArgumentException("Cannot update. Tour Guide with ID " + id + " does not exist.");
        }
        updatedTourGuide.setId(id);
        validateTourGuide(updatedTourGuide); // Custom validation
        return tourGuideRepository.save(updatedTourGuide);
    }

    // Validation logic for TourGuide
    private void validateTourGuide(TourGuide tourGuide) {
        if (tourGuide.getName() == null || tourGuide.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (tourGuide.getEmail() == null || tourGuide.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        if (tourGuide.getPhone() == null || tourGuide.getPhone().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty.");
        }
    }
}
