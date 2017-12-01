package pl.mareksowa.models.crews;
/**
 * Model Class
 */
public class Sailor extends Crew {
    /**
     * Variable of Model Class
     * @param strength
     * @param salary
     * @param consumption
     * @param production
     */
    public Sailor(int strength, int salary, int consumption, int production) {
        super(2, 2, 1, 2);
    }
}
