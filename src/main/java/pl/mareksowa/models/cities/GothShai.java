package pl.mareksowa.models.cities;

public class GothShai extends City {
    /**
     * Variable of standard Model Class
     */
    public GothShai(){
        setCityName(CityName.GOTH_SHAI);
        setCityPosition(shipMovement.getPositionField1());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(0);
        setWineRequest(2);
        setMahoganyRequest(0);
        setDecorationsRequest(2);
        setSilkRequest(-2);
        setSpicesRequest(3);
        setSlaveRequest(1);
    }
}
