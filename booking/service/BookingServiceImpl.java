package booking.service;

import java.util.Calendar;
import java.util.Date;

import booking.model.Booking;
import station.model.Station;
import station.service.IStationService;
import station.service.StationServiceImpl;
import storage.*;
import taxi.model.Taxi;
import taxi.service.ITaxiService;
import taxi.service.TaxiServiceImpl;

public class BookingServiceImpl implements IBookingService {

    private static IBookingService INSTANCE;

    private static IStorageService storageService;
    private static ITaxiService taxiService;
    private static IStationService stationService;

    public static IBookingService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookingServiceImpl();
        }
        return INSTANCE;
    }

    private BookingServiceImpl() {
        storageService = StorageServiceImpl.getInstance();
        taxiService = TaxiServiceImpl.getInstance();
        stationService = StationServiceImpl.getInstance();
    }
    
    @Override
    public Boolean book(String source, String destination, Date pickupTime) {
        Boolean bookingDone = Boolean.FALSE;
        try {
            Station sourceStation = stationService.find(source);
            Station destinationStation = stationService.find(destination);

            // Lock the taxi for other bookings
            Taxi taxi = taxiService.findTaxiCloseToStation(sourceStation, pickupTime);

            if (taxi == null) return false;

            // Create a booking object and add it to db as well as taxi's booking list
            Booking booking = new Booking();
            booking.setSource(sourceStation);
            booking.setDestination(destinationStation);
            booking.setPickupTime(pickupTime);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(pickupTime);
            calendar.add(Calendar.MINUTE,
                Math.abs(destinationStation.getTimeTakenFromSource() - sourceStation.getTimeTakenFromSource()));
            booking.setEndTime(calendar.getTime());

            // saving the booking
            storageService.saveBooking(booking);

            // saving the bookings of taxi
            taxi.getBookings().add(booking);
            taxiService.updateTaxi(taxi);

            bookingDone = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingDone;
    }
    
}
