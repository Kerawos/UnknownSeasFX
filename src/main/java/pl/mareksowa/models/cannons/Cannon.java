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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
