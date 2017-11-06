package pl.mareksowa.models.cities;

public abstract class City {

    protected String cityName;

    protected double foodRequest;
    protected double ammoRequest;
    protected double crewRequest;
    protected double sailRequest;
    protected double cannonRequest;

    protected double wheatRequest;
    protected double clothesRequest;
    protected double wineRequest;
    protected double mahoganyRequest;
    protected double decorationsRequest;
    protected double silkRequest;
    protected double spicesRequest;

    protected double slaveRequest;

    public City(String cityName) {
        this.cityName = cityName;
        foodRequest = 0;
        ammoRequest = 0;
        crewRequest = 0;
        sailRequest = 0;
        cannonRequest = 0;
        wheatRequest = 0;
        clothesRequest = 0;
        wineRequest = 0;
        mahoganyRequest = 0;
        decorationsRequest = 0;
        silkRequest = 0;
        spicesRequest = 0;
        slaveRequest = 0;
    }
}
