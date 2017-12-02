package pl.mareksowa.models.crews;
/**
 * Model Class
 */
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }
}
