package pl.mareksowa.models.crews;
/**
 * Model Class
 */
public class Engineer extends Crew {
    /**
     * Variable of Model Class
     * @param strength
     * @param salary
     * @param consumption
     * @param production
     */
    public Engineer(int strength, int salary, int consumption, int production) {
        super(1, 5, 2, 5);
    }
}
