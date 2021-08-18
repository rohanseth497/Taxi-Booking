import java.util.Date;

import booking.service.BookingServiceImpl;
import booking.service.IBookingService;
import station.service.IStationService;
import station.service.StationServiceImpl;
import taxi.service.ITaxiService;
import taxi.service.TaxiServiceImpl;

public class TaxiMain {
    public static void main(String[] args) {

        IStationService stationService = StationServiceImpl.getInstance();
        stationService.saveStation("A", 0, 0);
        stationService.saveStation("B", 15, 60);
        stationService.saveStation("C", 30, 120);
        stationService.saveStation("D", 45, 180);
        stationService.saveStation("E", 60, 240);
        stationService.saveStation("F", 75, 300);

        ITaxiService taxiService = TaxiServiceImpl.getInstance();
        taxiService.saveTaxi("1", "A");
        taxiService.saveTaxi("2", "B");
        taxiService.saveTaxi("3", "C");
        taxiService.saveTaxi("4", "D");
        taxiService.saveTaxi("5", "E");

        IBookingService bookingService = BookingServiceImpl.getInstance();
        Boolean isBooked = bookingService.book("A", "B", new Date(2021, 8, 18, 11, 0));
        if (isBooked) {
            System.out.println("Booked");
        } else {
            System.out.println("Not Booked");
        }

    }
}
