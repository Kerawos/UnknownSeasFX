package pl.mareksowa.models.ships;
/**
 * Import section
 */
import pl.mareksowa.models.cannons.Cannon;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.sails.Sail;
import pl.mareksowa.models.crews.Crew;

import java.util.ArrayList;
import java.util.List;
/**
 * Model Class
 */
public class Ship {
    private int storageCapacity;
    private List<Good> storage;
    private int cabinCapacity;
    private List<Crew> crewList;
    private int cannonCapacity;
    private List<Cannon> cannonList;
    private int endurance;
    private int currentEndurance;
    private int sailCapacity;
    private List<Sail> sailList;
    private int gold;
    private int food;
    private int ammo;
    private ShipAchievement achievement;
    private ShipPosition shipPosition;
    private int movePossibility;

    /**
     * Constructor of Class
     */
    public Ship(int storageCapacity, int cabinCapacity, int cannonCapacity, int endurance, int currentEndurance, int sailCapacity, int gold, int food, int ammo) {
        this.storageCapacity = storageCapacity;
        this.cabinCapacity = cabinCapacity;
        this.cannonCapacity = cannonCapacity;
        this.endurance = endurance;
        this.currentEndurance = currentEndurance;
        this.sailCapacity = sailCapacity;
        this.gold = gold;
        this.food = food;
        this.ammo = ammo;
        storage = new ArrayList<>();
        crewList = new ArrayList<>();
        cannonList = new ArrayList<>();
        sailList = new ArrayList<>();
        achievement = new ShipAchievement();
        shipPosition = new ShipPosition(0,0);

    }

    /**
     * Getters and Setters section
     */
    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public List<Good> getStorage() {
        return storage;
    }

    public void setStorage(List<Good> storage) {
        this.storage = storage;
    }

    public int getCabinCapacity() {
        return cabinCapacity;
    }

    public void setCabinCapacity(int cabinCapacity) {
        this.cabinCapacity = cabinCapacity;
    }

    public List<Crew> getCrewList() {
        return crewList;
    }

    public void setCrewList(List<Crew> crewList) {
        this.crewList = crewList;
    }

    public int getCannonCapacity() {
        return cannonCapacity;
    }

    public void setCannonCapacity(int cannonCapacity) {
        this.cannonCapacity = cannonCapacity;
    }

    public List<Cannon> getCannonList() {
        return cannonList;
    }

    public void setCannonList(List<Cannon> cannonList) {
        this.cannonList = cannonList;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getCurrentEndurance() {
        return currentEndurance;
    }

    public void setCurrentEndurance(int currentEndurance) {
        this.currentEndurance = currentEndurance;
    }

    public int getSailCapacity() {
        return sailCapacity;
    }

    public void setSailCapacity(int sailCapacity) {
        this.sailCapacity = sailCapacity;
    }

    public List<Sail> getSailList() {
        return sailList;
    }

    public void setSailList(List<Sail> sailList) {
        this.sailList = sailList;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public ShipAchievement getAchievement() {
        return achievement;
    }

    public void setAchievement(ShipAchievement achievement) {
        this.achievement = achievement;
    }

    public ShipPosition getShipPosition() {
        return shipPosition;
    }

    public void setShipPosition(ShipPosition shipPosition) {
        this.shipPosition = shipPosition;
    }

    public int getMovePossibility() {
        return movePossibility;
    }

    public void setMovePossibility(int movePossibility) {
        this.movePossibility = movePossibility;
    }

    /**
     * To compare or print city statistics
     */
    @Override
    public String toString() {
        return "Ship{" +
                "storageCapacity=" + storageCapacity +
                ", storage=" + storage +
                ", cabinCapacity=" + cabinCapacity +
                ", crewList=" + crewList +
                ", cannonCapacity=" + cannonCapacity +
                ", cannonList=" + cannonList +
                ", endurance=" + endurance +
                ", currentEndurance=" + currentEndurance +
                ", sailCapacity=" + sailCapacity +
                ", sailList=" + sailList +
                ", gold=" + gold +
                ", food=" + food +
                ", ammo=" + ammo +
                '}';
    }
}
