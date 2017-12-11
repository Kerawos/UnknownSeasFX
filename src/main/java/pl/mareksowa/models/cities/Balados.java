package pl.mareksowa.models.cities;

public class Balados extends City {

    public Balados(){
        setCityName(CityName.BALADOS);
        setCityPosition(shipMovement.getPositionField10());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(0);
        setWineRequest(2);
        setMahoganyRequest(0);
        setDecorationsRequest(0);
        setSilkRequest(2);
        setSpicesRequest(0);
        setSlaveRequest(0);
    }
}
