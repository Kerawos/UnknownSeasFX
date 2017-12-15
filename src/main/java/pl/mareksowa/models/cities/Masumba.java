package pl.mareksowa.models.cities;

public class Masumba extends City {
    /**
     * Variable of standard Model Class
     */
    public Masumba(){
        setCityName(CityName.MASUMBA);
        setCityPosition(getShipMovementManager().getPositionField4());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(1);
        setClothesRequest(0);
        setWineRequest(0);
        setMahoganyRequest(-1);
        setDecorationsRequest(0);
        setSilkRequest(0);
        setSpicesRequest(0);
        setSlaveRequest(1);
    }
}
