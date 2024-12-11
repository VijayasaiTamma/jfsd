package tour_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourDetailService {

    @Autowired
    private TourDetailRepository tourDetailRepository;

    public TourDetail saveTourDetail(TourDetail tourDetail) {
        return tourDetailRepository.save(tourDetail);
    }

    public List<TourDetail> getAllTourDetails() {
        return tourDetailRepository.findAll();
    }

    // Fetching a tour detail by ID
    public Optional<TourDetail> getTourDetailById(Long id) {
        return tourDetailRepository.findById(id);
    }

    // Deleting a tour detail by ID
    public void deleteTourDetail(Long id) {
        Optional<TourDetail> tour = tourDetailRepository.findById(id);
        if (tour.isPresent()) {
            tourDetailRepository.delete(tour.get());
        } else {
            throw new RuntimeException("Tour not found");
        }
    }
}
