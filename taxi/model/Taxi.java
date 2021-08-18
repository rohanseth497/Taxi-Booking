package taxi.model;

import java.util.List;
import java.util.ArrayList;

import booking.model.Booking;
import station.model.Station;
public class Taxi {
    private int Id;
    private String taxiNumber;
    private List<Booking> bookings = new ArrayList<>();
    private Station standByStation;

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTaxiNumber() {
        return this.taxiNumber;
    }

    public void setTaxiNumber(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Station getStandByStation() {
        return this.standByStation;
    }

    public void setStandByStation(Station standByStation) {
        this.standByStation = standByStation;
    }

}
