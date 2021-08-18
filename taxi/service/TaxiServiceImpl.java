package taxi.service;

import station.model.Station;
import storage.IStorageService;
import storage.StorageServiceImpl;
import taxi.model.Taxi;

public class TaxiServiceImpl implements ITaxiService {

    private static ITaxiService INSTANCE;

    private static IStorageService storageService;

    private TaxiServiceImpl() {
        storageService = StorageServiceImpl.getInstance();
    }

    public static ITaxiService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaxiServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public void saveTaxi(String taxiNumber) {
        Taxi taxi = new Taxi();
        taxi.setTaxiNumber(taxiNumber);
        taxi.setIsAvailable(Boolean.TRUE);
        
        storageService.saveTaxi(taxi);
    }

    @Override
    public Taxi findTaxiCloseToStation(Station station) {
        // If no taxi found, throw error and catch in Booking Service
        return null;
    }
    
}
