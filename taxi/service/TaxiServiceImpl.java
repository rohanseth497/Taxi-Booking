package taxi.service;

import java.util.Date;
import java.util.List;
import java.util.TreeMap;

import booking.model.Booking;
import station.model.Station;
import station.service.IStationService;
import station.service.StationServiceImpl;
import storage.IStorageService;
import storage.StorageServiceImpl;
import taxi.model.Taxi;

public class TaxiServiceImpl implements ITaxiService {

    private static ITaxiService INSTANCE;

    private static IStorageService storageService;
    private static IStationService stationService;

    private TaxiServiceImpl() {
        storageService = StorageServiceImpl.getInstance();
        stationService = StationServiceImpl.getInstance();
    }

    public static ITaxiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaxiServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public Taxi saveTaxi(String taxiNumber, String standByStaion) {
        Station station = stationService.find(standByStaion);

        Taxi taxi = new Taxi();
        taxi.setTaxiNumber(taxiNumber);
        taxi.setStandByStation(station);
        
        storageService.saveTaxi(taxi);
        return taxi;
    }

    @Override
    public Taxi findTaxiCloseToStation(Station station, Date pickupTime) {
        List<Taxi> allTaxis = storageService.getAllTaxis();
        Taxi bookingTaxi = null;

        TreeMap<Integer, Taxi> taxiSortedMap = new TreeMap<>();

        for (Taxi taxi: allTaxis) {
            boolean isTaxiAvailable = Boolean.TRUE;
            if (!taxi.getBookings().isEmpty()) {
                for (Booking booking : taxi.getBookings()) {
                    if (
                        pickupTime.compareTo(booking.getPickupTime()) >= 0 &&
                        pickupTime.compareTo(booking.getEndTime()) <= 0    
                    ) {
                        isTaxiAvailable = false;
                        break;
                    }
                }
                if (isTaxiAvailable) {
                    // check for closest distance
                    Integer diff = Math.abs(
                        taxi.getStandByStation().getDistanceFromSource() - 
                        station.getDistanceFromSource()
                    );;
                    taxiSortedMap.put(diff, taxi);
                }
            } else {
                // Taxi doesn't have a booking, check for closest distance
                Integer diff = Math.abs(
                    taxi.getStandByStation().getDistanceFromSource() - 
                    station.getDistanceFromSource()
                );
                taxiSortedMap.put(diff, taxi);
            }
        }

        if (!taxiSortedMap.isEmpty()) {
            bookingTaxi = taxiSortedMap.pollFirstEntry().getValue();
        }
       
        return bookingTaxi;
    }

    @Override
    public void updateTaxi(Taxi taxi) {
        storageService.updateTaxi(taxi);
    }
    
}
