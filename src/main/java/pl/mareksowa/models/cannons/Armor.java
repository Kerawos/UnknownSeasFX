package pl.mareksowa.models.cannons;

/**
 * Model Class - Armor will be treated as cannon because armor can take cannon slot on the ship
 */
public class Armor extends Cannon {
    /**
     * Variable of standard Model Class
     */
    public Armor() {
        super(20, 0);
    }
}
