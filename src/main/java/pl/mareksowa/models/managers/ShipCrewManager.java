package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.ships.Ship;

import java.util.List;

/**
 * Interface responsible for all crew member behaviours. Hire, rebellion, hunger, die.
 */
@Service
public interface ShipCrewManager {

    /**
     * Method checks if capitan of listed ship can hire given crew member
     * @param shipPlayer
     * @param crewToHire
     * @param lblUpperText
     * @return true if conditions have been met
     */
    boolean canHireCrewMember(Ship shipPlayer, Crew crewToHire, Label lblUpperText);
    /**
     * Method responsible for hiring given crew member by capitan of listed ship
     * @param shipPlayer
     * @param crewToHire
     */
    void hireCrewMember(Ship shipPlayer, Crew crewToHire);

    /**
     * Method checks if capitan of listed ship can get rid of given crew member
     * @param shipPlayer
     * @param crewListNo
     * @return true if conditions have been met
     */
    boolean canGetRidOffCrewMember(Ship shipPlayer, int crewListNo);

    /**
     * Method responsible for fire given crew member by capitan of listed ship
     * @param shipPlayer
     * @param crewToFire
     */
    void ridOffCrewMember(Ship shipPlayer, Crew crewToFire);

    /**
     * Method will generate random crew member from all available at this moment potential members
     * @return random crew member
     */
    Crew generateRandomCrewMember();

    /**
     * Method generate or not person to tavern which player can hire
     * @return 50% chance of random crew member
     */
    Crew generateCrewToTavern();

    /**
     * Method will generate list of crew member for city
     * @param capacityOfCityTavern
     * @return list of crew members
     */
    List<Crew> generateTavernList(int capacityOfCityTavern);

    /**
     * Support method for updating every image view in controller
     * @param crewMember
     * @param lblCrewName
     * @param lblCrewStrength
     * @param lblCrewSalary
     * @param lblCrewConsumption
     * @param lblCrewProduction
     * @param ivCrewToHire
     */
    void updateTavernAvailableCrew(Crew crewMember, Label lblCrewName, Label lblCrewStrength, Label lblCrewSalary,
                                   Label lblCrewConsumption, Label lblCrewProduction, ImageView ivCrewToHire);

    /**
     * Method which check if capitan can buy listed food to ship
     * @param shipPlayer
     * @param foodCost
     * @return tru if condition has been met
     */
    boolean canBuyFood(Ship shipPlayer, int foodCost);

    /**
     * Method which add given food quantity to the ship
     * @param shipPlayer
     * @param foodToAdd
     * @param goldToPay
     */
    void buyFood(Ship shipPlayer, int foodToAdd, int goldToPay);

    List<Crew> feedCrew(Ship shipPlayer);

    void crewRebellion(Ship shipPlayer, List<Crew> rebellions, List<Good> goodsToStole);

}
