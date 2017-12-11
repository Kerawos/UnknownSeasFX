package pl.mareksowa.models.cities;

public class MilaDoce extends City {

    public MilaDoce() {
        setCityName(CityName.MILA_DOCE);
        setCityPosition(shipMovement.getPositionField6());
        setFoodRequest(0);
        setAmmoRequest(0);
        setCrewRequest(0);
        setSailRequest(0);
        setCannonRequest(0);
        setWheatRequest(0);
        setClothesRequest(-1);
        setWineRequest(0);
        setMahoganyRequest(0);
        setDecorationsRequest(-2);
        setSilkRequest(0);
        setSpicesRequest(0);
        setSlaveRequest(0);
    }
}
