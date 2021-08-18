package booking.model;

import java.sql.Date;
import taxi.model.Taxi;

public class Booking {
    private int Id;
    private Date pickupTime;
    private Boolean isBookingCompleted;
    private Date endTime;
    private Taxi taxi;
    private String source;
    private String destination;

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getPickupTime() {
        return this.pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Boolean isIsBookingCompleted() {
        return this.isBookingCompleted;
    }

    public Boolean getIsBookingCompleted() {
        return this.isBookingCompleted;
    }

    public void setIsBookingCompleted(Boolean isBookingCompleted) {
        this.isBookingCompleted = isBookingCompleted;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Taxi getTaxi() {
        return this.taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
