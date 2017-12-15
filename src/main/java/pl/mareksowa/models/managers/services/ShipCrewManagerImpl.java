package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.CurrentScene;
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
        int rndInt = new Random().nextInt(10);
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
        int rndInt = new Random().nextInt(2);
        switch (rndInt){
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

    @Override
    public void updateTavernAvailableCrew(Crew crewMember, Label lblCrewName, Label lblCrewStrength, Label lblCrewSalary, Label lblCrewConsumption, Label lblCrewProduction, ImageView ivCrewToHire){
        String crewName = crewMember.getClass().getName();
        crewName = crewName.substring(crewName.lastIndexOf(".")+1, crewName.length());
        lblCrewName.setText(crewName);
        lblCrewStrength.setText("strength: " + crewMember.getStrength());
        lblCrewSalary.setText("salary: " + crewMember.getSalary());
        lblCrewConsumption.setText("consumption: " + crewMember.getConsumption());
        lblCrewProduction.setText("production: " + crewMember.getProduction());
        switch (crewName){
            case "DeckHand":{
                ivCrewToHire.setImage(new Image("img/crews/CrewMemberDeckHand.png"));
                break;
            }
            case "Sailor":{
                ivCrewToHire.setImage(new Image("img/crews/CrewMemberSailor.png"));
                break;
            }
            case "Chef":{
                ivCrewToHire.setImage(new Image("img/crews/CrewMemberChef.png"));
                break;
            }
            case "Engineer":{
                ivCrewToHire.setImage(new Image("img/crews/CrewMemberEngineer.png"));
                break;
            }
            case "SeaWolf":{
                ivCrewToHire.setImage(new Image("img/crews/CrewMemberSeaWolf.png"));
                break;
            }
            case "NoOne":{
                ivCrewToHire.setImage(new Image("img/crews/CrewEmpty.png"));
                lblCrewName.setText("No one available here");
                lblCrewStrength.setText("");
                lblCrewSalary.setText("");
                lblCrewConsumption.setText("");
                lblCrewProduction.setText("");
                break;
            }
        }
    }
}
