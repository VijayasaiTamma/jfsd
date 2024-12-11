package TourGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tour-guides")
public class TourGuideController {

    @Autowired
    private TourGuideService tourGuideService;

    // Get all tour guides
    @GetMapping
    public List<TourGuide> getAllTourGuides() {
        return tourGuideService.getAllTourGuides();
    }

    // Get tour guide by ID
    @GetMapping("/{id}")
    public ResponseEntity<TourGuide> getTourGuideById(@PathVariable("id") Long id) {
        Optional<TourGuide> tourGuide = tourGuideService.getTourGuideById(id);
        return tourGuide.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new tour guide
    @PostMapping
    public ResponseEntity<TourGuide> addTourGuide(@RequestBody TourGuide tourGuide) {
        System.out.println("Received Tour Guide: " + tourGuide);
        try {
            TourGuide createdTourGuide = tourGuideService.addTourGuide(tourGuide);
            return new ResponseEntity<>(createdTourGuide, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update a tour guide
    @PutMapping("/{id}")
    public ResponseEntity<TourGuide> updateTourGuide(@PathVariable("id") Long id, @RequestBody TourGuide tourGuide) {
        TourGuide updatedTourGuide = tourGuideService.updateTourGuide(id, tourGuide);
        return updatedTourGuide != null ? ResponseEntity.ok(updatedTourGuide) : ResponseEntity.notFound().build();
    }

    // Delete a tour guide
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTourGuide(@PathVariable("id") Long id) {
        tourGuideService.deleteTourGuide(id);
        return ResponseEntity.noContent().build();
    }
}