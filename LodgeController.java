package Lodge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lodges")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
public class LodgeController {

    @Autowired
    private LodgeService lodgeService;

    // Get all lodges
    @GetMapping
    public ResponseEntity<List<Lodge>> getAllLodges() {
        return ResponseEntity.ok(lodgeService.getAllLodges());
    }

    // Add a new lodge
    @PostMapping
    public ResponseEntity<Lodge> addLodge(@RequestBody Lodge lodge) {
        Lodge savedLodge = lodgeService.saveLodge(lodge);
        return ResponseEntity.ok(savedLodge);
    }

    // Delete a lodge
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLodge(@PathVariable Long id) {
        try {
            lodgeService.deleteLodge(id);  // Delete the lodge
            return ResponseEntity.ok("Lodge deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to delete lodge. Please try again.");
        }
    }
}
