package tour_management;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tour_details")
public class TourDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String tourName;
    private String description;
    private String fromLocation;
    private String toLocation;
    private String tourGuide;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private int totalDays;
    private String vehicleRegistrationNo;
    private String transportMode;
    private String lodgeName;
    private String lodgeType;
    private double ticketPrice;
    @Column(name = "image_url")
    private String imageUrl;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTourName() {
		return tourName;
	}
	public void setTourName(String tourName) {
		this.tourName = tourName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getTourGuide() {
		return tourGuide;
	}
	public void setTourGuide(String tourGuide) {
		this.tourGuide = tourGuide;
	}
	public LocalDateTime getStartDatetime() {
		return startDatetime;
	}
	public void setStartDatetime(LocalDateTime startDatetime) {
		this.startDatetime = startDatetime;
	}
	public LocalDateTime getEndDatetime() {
		return endDatetime;
	}
	public void setEndDatetime(LocalDateTime endDatetime) {
		this.endDatetime = endDatetime;
	}
	public int getTotalDays() {
		return totalDays;
	}
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}
	public String getVehicleRegistrationNo() {
		return vehicleRegistrationNo;
	}
	public void setVehicleRegistrationNo(String vehicleRegistrationNo) {
		this.vehicleRegistrationNo = vehicleRegistrationNo;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getLodgeName() {
		return lodgeName;
	}
	public void setLodgeName(String lodgeName) {
		this.lodgeName = lodgeName;
	}
	public String getLodgeType() {
		return lodgeType;
	}
	public void setLodgeType(String lodgeType) {
		this.lodgeType = lodgeType;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

    // Getters and Setters
}