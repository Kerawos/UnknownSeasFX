package pl.mareksowa.models.cities;
/**
 * Model Class
 */
public abstract class City {
    /**
     * Fundamental city requests for general wares that player will be operating. Each field will specify city.
     * Each city should be very unique. In one case some cities will value spices, other not etc.
     */
    private CityName cityName;
    private double foodRequest;
    private double ammoRequest;
    private double crewRequest;
    private double sailRequest;
    private double cannonRequest;

    private double wheatRequest;
    private double clothesRequest;
    private double wineRequest;
    private double mahoganyRequest;
    private double decorationsRequest;
    private double silkRequest;
    private double spicesRequest;

    private double slaveRequest;

    /**
     * Empty constructor
     */
    public City() {
    }

    /**
     * Constructor of City
     */
    public City(CityName cityName, double foodRequest, double ammoRequest, double crewRequest, double sailRequest,
                double cannonRequest, double wheatRequest, double clothesRequest, double wineRequest, double mahoganyRequest,
                double decorationsRequest, double silkRequest, double spicesRequest, double slaveRequest) {
        this.cityName = cityName;
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

    public double getFoodRequest() {
        return foodRequest;
    }

    public void setFoodRequest(double foodRequest) {
        this.foodRequest = foodRequest;
    }

    public double getAmmoRequest() {
        return ammoRequest;
    }

    public void setAmmoRequest(double ammoRequest) {
        this.ammoRequest = ammoRequest;
    }

    public double getCrewRequest() {
        return crewRequest;
    }

    public void setCrewRequest(double crewRequest) {
        this.crewRequest = crewRequest;
    }

    public double getSailRequest() {
        return sailRequest;
    }

    public void setSailRequest(double sailRequest) {
        this.sailRequest = sailRequest;
    }

    public double getCannonRequest() {
        return cannonRequest;
    }

    public void setCannonRequest(double cannonRequest) {
        this.cannonRequest = cannonRequest;
    }

    public double getWheatRequest() {
        return wheatRequest;
    }

    public void setWheatRequest(double wheatRequest) {
        this.wheatRequest = wheatRequest;
    }

    public double getClothesRequest() {
        return clothesRequest;
    }

    public void setClothesRequest(double clothesRequest) {
        this.clothesRequest = clothesRequest;
    }

    public double getWineRequest() {
        return wineRequest;
    }

    public void setWineRequest(double wineRequest) {
        this.wineRequest = wineRequest;
    }

    public double getMahoganyRequest() {
        return mahoganyRequest;
    }

    public void setMahoganyRequest(double mahoganyRequest) {
        this.mahoganyRequest = mahoganyRequest;
    }

    public double getDecorationsRequest() {
        return decorationsRequest;
    }

    public void setDecorationsRequest(double decorationsRequest) {
        this.decorationsRequest = decorationsRequest;
    }

    public double getSilkRequest() {
        return silkRequest;
    }

    public void setSilkRequest(double silkRequest) {
        this.silkRequest = silkRequest;
    }

    public double getSpicesRequest() {
        return spicesRequest;
    }

    public void setSpicesRequest(double spicesRequest) {
        this.spicesRequest = spicesRequest;
    }

    public double getSlaveRequest() {
        return slaveRequest;
    }

    public void setSlaveRequest(double slaveRequest) {
        this.slaveRequest = slaveRequest;
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
