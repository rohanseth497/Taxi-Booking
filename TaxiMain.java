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
        // stationService.saveStation("D", 45, 180);
        // stationService.saveStation("E", 60, 240);
        // stationService.saveStation("F", 75, 300);

        ITaxiService taxiService = TaxiServiceImpl.getInstance();
        taxiService.saveTaxi("1", "A");
        // taxiService.saveTaxi("2", "B");
        // taxiService.saveTaxi("3", "C");
        // taxiService.saveTaxi("4", "D");
        // taxiService.saveTaxi("5", "E");

        IBookingService bookingService = BookingServiceImpl.getInstance();
        
        Runnable one = () -> { 
            boolean isBookingDone = bookingService.book("A", "B", new Date(2021, 8, 18, 11, 0));
            System.out.println(isBookingDone);
        };
        Runnable two = () -> { 
            boolean isBookingDone = bookingService.book("A", "B", new Date(2021, 8, 18, 11, 0));
            System.out.println(isBookingDone);
        };

        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);

        t1.start();
        t2.start();
        // bookingService.book("B", "C", new Date(2021, 8, 18, 11, 0));
        // bookingService.book("C", "A", new Date(2021, 8, 18, 14, 0));
        // bookingService.book("A", "C", new Date(2021, 8, 18, 11, 0));
        // bookingService.book("C", "A", new Date(2021, 8, 18, 15, 0));

    }
}
