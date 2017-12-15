package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */

import javafx.scene.control.Label;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.crews.*;
import pl.mareksowa.models.managers.ShipCrewManager;
import pl.mareksowa.models.ships.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Service responsible for all crew member behaviours. Hire, rebellion, hunger, die.
 */
@Repository
public class ShipCrewManagerImpl implements ShipCrewManager{

    @Override
    public boolean canHireCrewMember(Ship shipPlayer, Crew crewToHire, Label lblUpperText) {
        return false;
    }

    @Override
    public void hireCrewMember(Ship shipPlayer, Crew crewToHire) {

    }

    @Override
    public boolean canGetRidOffCrewMember(Ship shipPlayer, Crew crewToFire, Label lblUpperText) {
        return false;
    }

    @Override
    public void ridOffCrewMember(Ship shipPlayer, Crew crewToFire) {

    }

    // 30% chance of DeckHand and Sailor, 20% chance of Chef, 10% chance of SeaWolf and Engineer.
    @Override
    public Crew generateRandomCrewMember() {
        int rndInt = new Random().nextInt(9);
        if (rndInt<=2){
            return new DeckHand();
        } else if (rndInt>2 && rndInt<=5){
            return new Sailor();
        } else if (rndInt>5 && rndInt<=7){
            return new Chef();
        } else if (rndInt==8){
            return new Engineer();
        } else {
            return new SeaWolf();
        }
    }

    @Override
    public Crew generateCrewToTavern() {
        switch (new Random().nextInt()){
            case 0:{
                return new NoOne();
            }
            case 1:{
                return generateRandomCrewMember();
            }
            default:{
                return new NoOne();
            }
        }
    }

    @Override
    public List<Crew> generateTavernList(int capacityOfCityTavern) {
        List<Crew> tavernCrewList = new ArrayList<>();
        for (int i = 0; i < capacityOfCityTavern; i++) {
            tavernCrewList.add(generateCrewToTavern());
        }
        return tavernCrewList;
    }
}
