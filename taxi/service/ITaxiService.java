package taxi.service;

import java.util.Date;

import station.model.Station;
import taxi.model.Taxi;

public interface ITaxiService {
    Taxi saveTaxi(String taxiNumber, String standByStation);
    void updateTaxi(Taxi taxi);
    Taxi findTaxiCloseToStation(Station station, Date pickupTime);
    Taxi findTaxi(int id);
}
