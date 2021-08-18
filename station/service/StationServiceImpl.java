package station.service;

import station.model.Station;
import storage.IStorageService;
import storage.StorageServiceImpl;

public class StationServiceImpl implements IStationService {

    private static IStationService INSTANCE;

    private static IStorageService storageService;

    public static IStationService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new StationServiceImpl();
        }
        return INSTANCE;
    }

    private StationServiceImpl() {
        storageService = StorageServiceImpl.getInstance();
    }

    @Override
    public void saveStation(String name, int distanceFromSource, int timeTakenFromSource) {
        Station station = new Station();
        station.setName(name);
        station.setDistanceFromSource(distanceFromSource);
        station.setTimeTakenFromSource(timeTakenFromSource);

        storageService.saveStation(station);
    }

    @Override
    public Station find(String name) {
        return storageService.findStation(name);
    }
    
}
