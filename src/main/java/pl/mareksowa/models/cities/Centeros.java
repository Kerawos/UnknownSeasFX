package pl.mareksowa.models.cities;
/**
 * Model Class
 */
public class Centeros extends City {
    /**
     * Variable of standard Model Class
     */
    public Centeros(){

        setCityName(CityName.CENTEROS);
        setCityPosition(shipMovement.getPositionField14());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);

        setWheatRequest(-1);
        setClothesRequest(0);
        setWineRequest(-1);
        setMahoganyRequest(0);
        setDecorationsRequest(1);
        setSilkRequest(0);
        setSpicesRequest(0);
        setSlaveRequest(-10);
    }
}
