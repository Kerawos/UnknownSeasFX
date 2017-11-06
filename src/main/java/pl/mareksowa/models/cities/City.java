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

    public City() {
        cityName = "";
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

    public String getCityName() {
        return cityName;
    }

    public double getFoodRequest() {
        return foodRequest;
    }

    public double getAmmoRequest() {
        return ammoRequest;
    }

    public double getCrewRequest() {
        return crewRequest;
    }

    public double getSailRequest() {
        return sailRequest;
    }

    public double getCannonRequest() {
        return cannonRequest;
    }

    public double getWheatRequest() {
        return wheatRequest;
    }

    public double getClothesRequest() {
        return clothesRequest;
    }

    public double getWineRequest() {
        return wineRequest;
    }

    public double getMahoganyRequest() {
        return mahoganyRequest;
    }

    public double getDecorationsRequest() {
        return decorationsRequest;
    }

    public double getSilkRequest() {
        return silkRequest;
    }

    public double getSpicesRequest() {
        return spicesRequest;
    }

    public double getSlaveRequest() {
        return slaveRequest;
    }
}
