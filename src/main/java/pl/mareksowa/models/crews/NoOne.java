package pl.mareksowa.models.crews;

/**
 * Model exist to prevent nullpointer exc
 */
public class NoOne extends Crew {

    public NoOne() {
        super(0, 0, 0, 0);
    }
}
