package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.crews.Crew;
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
     * @param crewToFire
     * @param lblUpperText
     * @return true if conditions have been met
     */
    boolean canGetRidOffCrewMember(Ship shipPlayer, Crew crewToFire, Label lblUpperText);

    /**
     * Method responsible for fire given crew member by capitan of listed ship
     * @param shipPlayer
     * @param crewToFire
     */
    void ridOffCrewMember(Ship shipPlayer, Crew crewToFire);

    Crew generateRandomCrewMember();

    Crew generateCrewToTavern();

    List<Crew> generateTavernList(int capacityOfCityTavern);

    void updateTavernAvailableCrew(Crew crewMember, Label lblCrewStrength, Label lblCrewSalary, Label lblCrewConsumption, Label lblCrewProduction, ImageView ivCrewToHire);
}
