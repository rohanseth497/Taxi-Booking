package taxi.model;

import java.util.Date;

public class Taxi {
    private int Id;
    private String taxiNumber;
    private Date startTime;
    private Boolean isAvailable;

    public int getId() {
        return this.Id;
    }

    public String getTaxiNumber() {
        return this.taxiNumber;
    }

    public void setTaxiNumber(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Boolean isIsAvailable() {
        return this.isAvailable;
    }

    public Boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
