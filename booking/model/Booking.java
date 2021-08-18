package booking.model;

import java.util.Date;

import station.model.Station;

public class Booking {
    private int Id;
    private Date pickupTime;
    private Boolean isBookingCompleted;
    private Date endTime;
    private Station source;
    private Station destination;

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


    public Station getSource() {
        return this.source;
    }

    public void setSource(Station source) {
        this.source = source;
    }

    public Station getDestination() {
        return this.destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }


}
