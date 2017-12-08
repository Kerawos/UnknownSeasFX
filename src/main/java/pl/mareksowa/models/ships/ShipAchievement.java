package pl.mareksowa.models.ships;

public class ShipAchievement {

    private boolean firstTimeInGame;
    private boolean firstTimeInWorldMap;
    private boolean firstTimeInCity;
    private boolean firstTimeInMarket;
    private boolean firstTimeInStorage;
    private boolean firstTimeInTavern;
    private boolean firstTimeInDockyard;
    private boolean firstTimeInBattle;
    private boolean firstTimeLooseBattle;
    private boolean firstTimeWinBattle;
    private boolean firstTimeTakeDamage;
    private boolean firstTimeHireCrew;

    public boolean isFirstTimeInGame() {
        return firstTimeInGame;
    }

    public void setFirstTimeInGame(boolean firstTimeInGame) {
        this.firstTimeInGame = firstTimeInGame;
    }

    public boolean isFirstTimeInWorldMap() {
        return firstTimeInWorldMap;
    }

    public void setFirstTimeInWorldMap(boolean firstTimeInWorldMap) {
        this.firstTimeInWorldMap = firstTimeInWorldMap;
    }

    public boolean isFirstTimeInCity() {
        return firstTimeInCity;
    }

    public void setFirstTimeInCity(boolean firstTimeInCity) {
        this.firstTimeInCity = firstTimeInCity;
    }

    public boolean isFirstTimeInMarket() {
        return firstTimeInMarket;
    }

    public void setFirstTimeInMarket(boolean firstTimeInMarket) {
        this.firstTimeInMarket = firstTimeInMarket;
    }

    public boolean isFirstTimeInStorage() {
        return firstTimeInStorage;
    }

    public void setFirstTimeInStorage(boolean firstTimeInStorage) {
        this.firstTimeInStorage = firstTimeInStorage;
    }

    public boolean isFirstTimeInTavern() {
        return firstTimeInTavern;
    }

    public void setFirstTimeInTavern(boolean firstTimeInTavern) {
        this.firstTimeInTavern = firstTimeInTavern;
    }

    public boolean isFirstTimeInDockyard() {
        return firstTimeInDockyard;
    }

    public void setFirstTimeInDockyard(boolean firstTimeInDockyard) {
        this.firstTimeInDockyard = firstTimeInDockyard;
    }

    public boolean isFirstTimeInBattle() {
        return firstTimeInBattle;
    }

    public void setFirstTimeInBattle(boolean firstTimeInBattle) {
        this.firstTimeInBattle = firstTimeInBattle;
    }

    public boolean isFirstTimeLooseBattle() {
        return firstTimeLooseBattle;
    }

    public void setFirstTimeLooseBattle(boolean firstTimeLooseBattle) {
        this.firstTimeLooseBattle = firstTimeLooseBattle;
    }

    public boolean isFirstTimeWinBattle() {
        return firstTimeWinBattle;
    }

    public void setFirstTimeWinBattle(boolean firstTimeWinBattle) {
        this.firstTimeWinBattle = firstTimeWinBattle;
    }

    public boolean isFirstTimeTakeDamage() {
        return firstTimeTakeDamage;
    }

    public void setFirstTimeTakeDamage(boolean firstTimeTakeDamage) {
        this.firstTimeTakeDamage = firstTimeTakeDamage;
    }

    public boolean isFirstTimeHireCrew() {
        return firstTimeHireCrew;
    }

    public void setFirstTimeHireCrew(boolean firstTimeHireCrew) {
        this.firstTimeHireCrew = firstTimeHireCrew;
    }
}
