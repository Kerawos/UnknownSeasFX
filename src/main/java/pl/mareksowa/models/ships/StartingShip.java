package pl.mareksowa.models.ships;
/**
 * This class exist only to generate starting ship for player.
 */
public class StartingShip {
    /**
     * Declaration of potential ship
     */
    private Ship startingShip;

    /**
     * Method that generate new starting ship.
     * @return starting ship.
     */
    public Ship getStartingShip(){
        return new Ship(1,1,1,
                100,100,1,100,5,0);
    }
}
