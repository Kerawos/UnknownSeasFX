package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Repository;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.crews.*;
import pl.mareksowa.models.goods.Good;
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
        String crewName = crewToHire.getClass().getName();
        crewName = crewName.substring(crewName.lastIndexOf(".")+1, crewName.length());
        if (crewName.equals("NoOne")){
            return false;
        }
        if (shipPlayer.getCabinCapacity() > shipPlayer.getCrewList().size()){
            return true;
        }
        lblUpperText.setText("You don't have enough space..");
        return false;

    }

    @Override
    public void hireCrewMember(Ship shipPlayer, Crew crewToHire) {
        shipPlayer.getCrewList().add(crewToHire);

    }

    @Override
    public boolean canGetRidOffCrewMember(Ship shipPlayer, int crewListNo) {
        if (shipPlayer.getCrewList().size()>0){
            String givenCrewName = shipPlayer.getCrewList().get(crewListNo).getClass().getName();
            givenCrewName = givenCrewName.substring(givenCrewName.lastIndexOf(".")+1, givenCrewName.length());
            for (int i = 0; i < shipPlayer.getCrewList().size(); i++) {
                String currentCrewName = shipPlayer.getCrewList().get(i).getClass().getName();
                currentCrewName = currentCrewName.substring(currentCrewName.lastIndexOf(".")+1, currentCrewName.length());
                if (currentCrewName.equals(givenCrewName)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void ridOffCrewMember(Ship shipPlayer, Crew crewToFire) {
        for (int i = 0; i < shipPlayer.getCrewList().size(); i++) {
            if (shipPlayer.getCrewList().get(i).equals(crewToFire)){
                shipPlayer.getCrewList().remove(i);
                break;
            }
        }
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

    @Override
    public boolean canBuyFood(Ship shipPlayer, int foodCost) {
        if (shipPlayer.getGold()>= foodCost){
            return true;
        }
        return false;
    }

    @Override
    public void buyFood(Ship shipPlayer, int foodToAdd, int goldToPay) {
        shipPlayer.setFood(shipPlayer.getFood() + foodToAdd);
        shipPlayer.setGold(shipPlayer.getGold() - goldToPay);
    }

    @Override
    public List<Crew> feedCrew(Ship shipPlayer) {
        List<Crew> rebellions = new ArrayList<>();
        for (Crew crew : shipPlayer.getCrewList()) {
            if (shipPlayer.getFood()>=crew.getConsumption()){
                shipPlayer.setFood(shipPlayer.getFood()-crew.getConsumption());
            } else {
                rebellions.add(crew);
                shipPlayer.getCrewList().remove(crew);
            }
        }
        return rebellions;
    }

    @Override
    public void crewRebellion(Ship shipPlayer, List<Crew> rebellions, List<Good> goodsToStole) {
        List<Good> goods = shipPlayer.getStorage();
        for (Good good : goods) {
            for (Good good1 : goodsToStole) {
                if (good.equals(good1)){
                    shipPlayer.getStorage().remove(good);
                }
            }
        }
    }


}
