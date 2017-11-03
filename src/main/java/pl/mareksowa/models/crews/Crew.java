package pl.mareksowa.models.crews;

public abstract class Crew {
    private int strength;
    private int salary;
    private int consumption;
    private int production;

    public Crew(int strength, int salary, int consupmtion, int production) {
        this.strength = strength;
        this.salary = salary;
        this.consumption = consupmtion;
        this.production = production;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": S" + strength + " $" + salary + " C:" + consumption + " P" + production;
    }
}
