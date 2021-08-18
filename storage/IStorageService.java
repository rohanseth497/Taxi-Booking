package storage;

import java.util.List;

import booking.model.Booking;
import station.model.Station;
import taxi.model.Taxi;

public interface IStorageService {
    Integer saveTaxi(Taxi taxi);
    List<Integer> saveAllTaxi(List<Taxi> taxies);
    Integer saveStation(Station station);
    Integer saveBooking(Booking booking);

    Station findStation(String name);
}