package storage;

import java.util.List;

import booking.model.Booking;
import station.model.Station;
import taxi.model.Taxi;

public interface IStorageService {
    Integer saveTaxi(Taxi taxi);
    List<Integer> saveAllTaxi(List<Taxi> taxies);
    Integer saveStation(Station station);
    Booking saveBooking(Booking booking);

    Station findStation(String name);
    List<Taxi> getAllTaxis();
    Booking findBooking(int bookingId);
    Taxi findTaxi(int id);

    void updateTaxi(Taxi taxi);
}