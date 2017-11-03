package pl.mareksowa.models.sails;

public abstract class Sail {
    private int price;
    private int speed;
    private int maneuver;

    public Sail(int price, int speed, int maneuver) {
        this.price = price;
        this.speed = speed;
        this.maneuver = maneuver;
    }
}
