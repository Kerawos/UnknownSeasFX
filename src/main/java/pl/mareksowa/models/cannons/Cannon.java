package pl.mareksowa.models.cannons;
/**
 * Model Class
 */
public abstract class Cannon {
    private int price;
    private int strength;

    public Cannon(int price, int strength) {
        this.price = price;
        this.strength = strength;
    }
}
