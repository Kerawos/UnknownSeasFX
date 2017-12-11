package pl.mareksowa.models.cities;

import pl.mareksowa.models.functionalities.ShipMovement;
import pl.mareksowa.models.functionalities.services.ShipMovementImpl;
import pl.mareksowa.models.ships.ShipPosition;

/**
 * Model Class
 */
public abstract class City {
    /**
     * Fundamental city requests for general wares that player will be operating. Each field will specify city.
     * Each city should be very unique. In one case some cities will value spices, other not etc.
     */
    private CityName cityName;
    private ShipPosition cityPosition;
    private int foodRequest;
    private int ammoRequest;
    private int crewRequest;
    private int sailRequest;
    private int cannonRequest;

    private int wheatRequest;
    private int clothesRequest;
    private int wineRequest;
    private int mahoganyRequest;
    private int decorationsRequest;
    private int silkRequest;
    private int spicesRequest;

    private int slaveRequest;

    public ShipMovement shipMovement = new ShipMovementImpl();

    /**
     * Empty constructor
     */
    public City() {
    }

    /**
     * Constructor of City
     */
    public City(CityName cityName, ShipPosition cityPosition, int foodRequest, int ammoRequest, int crewRequest,
                int sailRequest, int cannonRequest, int wheatRequest, int clothesRequest, int wineRequest, int mahoganyRequest,
                int decorationsRequest, int silkRequest, int spicesRequest, int slaveRequest, ShipMovement shipMovement) {
        this.cityName = cityName;
        this.cityPosition = cityPosition;
        this.foodRequest = foodRequest;
        this.ammoRequest = ammoRequest;
        this.crewRequest = crewRequest;
        this.sailRequest = sailRequest;
        this.cannonRequest = cannonRequest;
        this.wheatRequest = wheatRequest;
        this.clothesRequest = clothesRequest;
        this.wineRequest = wineRequest;
        this.mahoganyRequest = mahoganyRequest;
        this.decorationsRequest = decorationsRequest;
        this.silkRequest = silkRequest;
        this.spicesRequest = spicesRequest;
        this.slaveRequest = slaveRequest;
        this.shipMovement = shipMovement;
    }

    /**
     * Getters and Setters section
     */
    public CityName getCityName() {
        return cityName;
    }

    public void setCityName(CityName cityName) {
        this.cityName = cityName;
    }

    public ShipPosition getCityPosition() {
        return cityPosition;
    }

    public void setCityPosition(ShipPosition cityPosition) {
        this.cityPosition = cityPosition;
    }

    public int getFoodRequest() {
        return foodRequest;
    }

    public void setFoodRequest(int foodRequest) {
        this.foodRequest = foodRequest;
    }

    public int getAmmoRequest() {
        return ammoRequest;
    }

    public void setAmmoRequest(int ammoRequest) {
        this.ammoRequest = ammoRequest;
    }

    public int getCrewRequest() {
        return crewRequest;
    }

    public void setCrewRequest(int crewRequest) {
        this.crewRequest = crewRequest;
    }

    public int getSailRequest() {
        return sailRequest;
    }

    public void setSailRequest(int sailRequest) {
        this.sailRequest = sailRequest;
    }

    public int getCannonRequest() {
        return cannonRequest;
    }

    public void setCannonRequest(int cannonRequest) {
        this.cannonRequest = cannonRequest;
    }

    public int getWheatRequest() {
        return wheatRequest;
    }

    public void setWheatRequest(int wheatRequest) {
        this.wheatRequest = wheatRequest;
    }

    public int getClothesRequest() {
        return clothesRequest;
    }

    public void setClothesRequest(int clothesRequest) {
        this.clothesRequest = clothesRequest;
    }

    public int getWineRequest() {
        return wineRequest;
    }

    public void setWineRequest(int wineRequest) {
        this.wineRequest = wineRequest;
    }

    public int getMahoganyRequest() {
        return mahoganyRequest;
    }

    public void setMahoganyRequest(int mahoganyRequest) {
        this.mahoganyRequest = mahoganyRequest;
    }

    public int getDecorationsRequest() {
        return decorationsRequest;
    }

    public void setDecorationsRequest(int decorationsRequest) {
        this.decorationsRequest = decorationsRequest;
    }

    public int getSilkRequest() {
        return silkRequest;
    }

    public void setSilkRequest(int silkRequest) {
        this.silkRequest = silkRequest;
    }

    public int getSpicesRequest() {
        return spicesRequest;
    }

    public void setSpicesRequest(int spicesRequest) {
        this.spicesRequest = spicesRequest;
    }

    public int getSlaveRequest() {
        return slaveRequest;
    }

    public void setSlaveRequest(int slaveRequest) {
        this.slaveRequest = slaveRequest;
    }

    public ShipMovement getShipMovement() {
        return shipMovement;
    }

    public void setShipMovement(ShipMovement shipMovement) {
        this.shipMovement = shipMovement;
    }

    /**
     * To compare or print city statistics
     */
    @Override
    public String toString() {
        return "City{" +
                "cityName=" + cityName +
                ", foodRequest=" + foodRequest +
                ", ammoRequest=" + ammoRequest +
                ", crewRequest=" + crewRequest +
                ", sailRequest=" + sailRequest +
                ", cannonRequest=" + cannonRequest +
                ", wheatRequest=" + wheatRequest +
                ", clothesRequest=" + clothesRequest +
                ", wineRequest=" + wineRequest +
                ", mahoganyRequest=" + mahoganyRequest +
                ", decorationsRequest=" + decorationsRequest +
                ", silkRequest=" + silkRequest +
                ", spicesRequest=" + spicesRequest +
                ", slaveRequest=" + slaveRequest +
                '}';
    }
}
