package tour_management;


import org.springframework.data.jpa.repository.JpaRepository;

public interface TourDetailRepository extends JpaRepository<TourDetail, Long> {
}