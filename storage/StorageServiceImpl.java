package storage;

import java.util.*;

import booking.model.Booking;
import taxi.model.Taxi;
import station.model.Station;

public class StorageServiceImpl implements IStorageService {
    public static Map<Integer, Taxi> taxiMap = new HashMap<>();
    public static Map<String, Station> stationMap = new HashMap<>();
    public static Map<Integer, Booking> bookingMap = new HashMap<>();

    private static IStorageService INSTANCE;

    private StorageServiceImpl() {}

    public static IStorageService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StorageServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public Integer saveTaxi(Taxi taxi) {
        Integer primaryKey = 100 + (int) (Math.random() * 200);
        taxi.setId(primaryKey);
        taxiMap.put(primaryKey, taxi);

        return primaryKey;
    }
    @Override
    public Integer saveStation(Station station) {
        Integer primaryKey = 100 + (int) (Math.random() * 200);
        station.setStationId(primaryKey);
        stationMap.put(station.getName(), station);

        return primaryKey;
    }

    @Override
    public List<Integer> saveAllTaxi(List<Taxi> taxies) {
        List<Integer> primaryKeys = new ArrayList<>();

        for (Taxi taxi : taxies)
            primaryKeys.add(saveTaxi(taxi));

        return primaryKeys;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        Integer primaryKey = 100 + (int) (Math.random() * 200);
        booking.setId(primaryKey);
        bookingMap.put(primaryKey, booking);

        return booking;
    }

    @Override
    public Station findStation(String name) {
        Station result = stationMap.get(name);
        return result;
    }

    @Override
    public List<Taxi> getAllTaxis() {
        List<Taxi> allTaxies = new ArrayList<>();
        taxiMap.forEach((index, taxi) -> {
            allTaxies.add(taxi);
        });
        return allTaxies;
    }

    @Override
    public void updateTaxi(Taxi taxi) {
        taxiMap.put(taxi.getId(), taxi);
    }

    @Override
    public Booking findBooking(int bookingId) {
       return bookingMap.get(bookingId);
    }

    @Override
    public Taxi findTaxi(int id) {
        return taxiMap.get(id);
    }
}
