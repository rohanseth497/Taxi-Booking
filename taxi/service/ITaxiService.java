package taxi.service;

import station.model.Station;
import taxi.model.Taxi;

public interface ITaxiService {
    void saveTaxi(String taxiNumber);
    Taxi findTaxiCloseToStation(Station station);
}
