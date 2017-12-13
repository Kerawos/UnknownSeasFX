package pl.mareksowa.models.cities;

public class Balados extends City {

    public Balados(){
        setCityName(CityName.BALADOS);
        setCityPosition(shipMovementManager.getPositionField10());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(0);
        setWineRequest(1);
        setMahoganyRequest(0);
        setDecorationsRequest(0);
        setSilkRequest(1);
        setSpicesRequest(0);
        setSlaveRequest(0);
    }
}
