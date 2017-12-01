package pl.mareksowa.models.ships;

public class StartingShip {

    private Ship startingShip;

    public Ship getStartingShip(){
        return new Ship(1,1,1,100,100,1,100,5,0);
    }
}
