package tour_management;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

	import java.util.List;
import java.util.Optional;

	@RestController
	@RequestMapping("/api/tours")
	@CrossOrigin(origins = "http://localhost:3000") // React frontend URL
	public class TourDetailController {

	    @Autowired
	    private TourDetailService tourDetailService;

	    @PostMapping("/add")
	    public TourDetail addTourDetail(@RequestBody TourDetail tourDetail) {
	        return tourDetailService.saveTourDetail(tourDetail);
	    }

	    @GetMapping("/all")
	    public List<TourDetail> getAllTours() {
	        return tourDetailService.getAllTourDetails();
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteTourDetail(@PathVariable Long id) {
	        try {
	            // Ensure the tour exists
	            Optional<TourDetail> tour = tourDetailService.getTourDetailById(id);
	            if (tour.isPresent()) {
	                tourDetailService.deleteTourDetail(id);
	                return ResponseEntity.ok("Tour deleted successfully!");
	            } else {
	                return ResponseEntity.status(404).body("Tour not found");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Failed to delete tour. Please try again.");
	        }
	    }

	    
	}


