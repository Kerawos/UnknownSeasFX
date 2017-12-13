package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */

import javafx.scene.control.Label;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.managers.ShipCrewManager;
import pl.mareksowa.models.ships.Ship;

/**
 * Service responsible for all crew member behaviours. Hire, rebellion, hunger, die.
 */
@Service
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
}
