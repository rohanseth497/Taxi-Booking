package station.service;

import station.model.Station;

public interface IStationService {
    Station saveStation(String name, int distanceFromSource, int timeTakenFromSource);
    Station find(String name);
}
