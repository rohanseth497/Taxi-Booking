package booking.service;

import java.util.Date;

public interface IBookingService {
    Boolean book(String source, String destination, Date pickupTime);
    void completeBooking(int bookingId, int taxiId);
}
