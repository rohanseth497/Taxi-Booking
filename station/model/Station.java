package station.model;

public class Station {
    private int stationId;
    private String name;
    private int distanceFromSource;
    private int timeTakenFromSource;

    public int getTimeTakenFromSource() {
        return this.timeTakenFromSource;
    }

    public void setTimeTakenFromSource(int timeTakenFromSource) {
        this.timeTakenFromSource = timeTakenFromSource;
    }

    public int getStationId() {
        return this.stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceFromSource() {
        return this.distanceFromSource;
    }

    public void setDistanceFromSource(int distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }
}
