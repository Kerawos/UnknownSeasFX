package pl.mareksowa.models.sails;

/**
 * Model Class
 */
public abstract class Sail {
    protected int price;
    protected int speed;
    protected int maneuver;

    public Sail() {
        price = 0;
        speed = 0;
        maneuver = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public int getManeuver() {
        return maneuver;
    }
}
