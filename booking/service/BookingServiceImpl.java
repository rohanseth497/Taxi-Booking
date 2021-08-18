package booking.service;

import java.util.Date;

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
            Station station = stationService.find(source);
            // Lock the taxi for other bookings
            Taxi taxi = taxiService.findTaxiCloseToStation(station);

            bookingDone = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookingDone;
    }
    
}
