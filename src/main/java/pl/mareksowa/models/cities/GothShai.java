package pl.mareksowa.models.cities;

public class GothShai extends City {
    /**
     * Variable of standard Model Class
     */
    public GothShai(){
        setCityName(CityName.GOTH_SHAI);
        setCityPosition(getShipMovementManager().getPositionField1());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(0);
        setWineRequest(1);
        setMahoganyRequest(0);
        setDecorationsRequest(1);
        setSilkRequest(-1);
        setSpicesRequest(1);
        setSlaveRequest(1);
    }
}
