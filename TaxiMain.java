import java.util.Date;

import booking.service.BookingServiceImpl;
import booking.service.IBookingService;
import station.service.IStationService;
import station.service.StationServiceImpl;
import taxi.service.ITaxiService;
import taxi.service.TaxiServiceImpl;

public class TaxiMain {
    public static void main(String[] args) {
        
        ITaxiService taxiService = TaxiServiceImpl.getInstance();
        taxiService.saveTaxi("1");
        taxiService.saveTaxi("2");
        taxiService.saveTaxi("3");
        taxiService.saveTaxi("4");
        taxiService.saveTaxi("5");

        IStationService stationService = StationServiceImpl.getInstance();
        stationService.saveStation("A", 0, 0);
        stationService.saveStation("B", 15, 60);
        stationService.saveStation("C", 30, 120);
        stationService.saveStation("D", 45, 180);
        stationService.saveStation("E", 60, 240);
        stationService.saveStation("F", 75, 300);

        IBookingService bookingService = BookingServiceImpl.getInstance();
        bookingService.book("A", "B", new Date(2021, 8, 18, 11, 0));

    }
}
