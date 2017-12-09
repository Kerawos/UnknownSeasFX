package pl.mareksowa.models.cities;

public class Zihlu extends City {
    /**
     * Variable of standard Model Class
     */
    public Zihlu(){
        setCityName(CityName.ZIHLU);
        setCityPosition(shipMovement.getPositionField17());
        setFoodRequest(1);
        setAmmoRequest(1);
        setCrewRequest(1);
        setSailRequest(1);
        setCannonRequest(1);
        setWheatRequest(1);
        setClothesRequest(1);
        setWineRequest(1);
        setMahoganyRequest(1);
        setDecorationsRequest(1);
        setSilkRequest(1);
        setSpicesRequest(1);
        setSlaveRequest(0);
    }
}