package station.service;

import station.model.Station;

public interface IStationService {
    void saveStation(String name, int distanceFromSource, int timeTakenFromSource);
    Station find(String name);
}
