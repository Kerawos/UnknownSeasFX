package pl.mareksowa.models.cities;

public class Zihlu extends City {
    /**
     * Variable of standard Model Class
     */
    public Zihlu(){
        setCityName(CityName.ZIHLU);
        setCityPosition(getShipMovementManager().getPositionField17());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(1);
        setWineRequest(0);
        setMahoganyRequest(1);
        setDecorationsRequest(0);
        setSilkRequest(0);
        setSpicesRequest(-1);
        setSlaveRequest(0);
    }
}
