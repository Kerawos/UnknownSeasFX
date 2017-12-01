package pl.mareksowa.models.crews;
/**
 * Model Class
 */
public class Slave extends Crew {
    /**
     * Variable of Model Class
     * @param strength
     * @param salary
     * @param consumption
     * @param production
     */
    public Slave(int strength, int salary, int consumption, int production) {
        super(1, 0, 1, 1);
    }
}
