package pl.mareksowa.models.managers.services;
/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.mareksowa.models.maps.EncounterType;
import pl.mareksowa.models.maps.FieldColor;
import pl.mareksowa.models.ships.Ship;

import java.util.Random;

/**
 * Service responsible for every encounter on map
 */
@Service
public class EncounterManager {

    /**
     * Method generate encounter based on game map color field
     * @param shipPlayer
     * @return random encounter type
     */
    public EncounterType generateEncounterType(Ship shipPlayer){
        int random = new Random().nextInt(5)-1;
        System.out.println("random 1 = " + random);
        if (shipPlayer.getMapPosition().getFieldColor()== FieldColor.GREEN){
            random+=1;
        }
        if (shipPlayer.getMapPosition().getFieldColor()== FieldColor.RED){
            random-=1;
        }
        System.out.println("random = " + random);
        switch (random){
            case -2:{
                return EncounterType.PIRATE;
            }
            case -1:{
                return EncounterType.MONSTER;
            }
            case 0:{
                return EncounterType.EMPTY;
            }
            case 1:{
                return EncounterType.ADVENTURE;
            }
            case 2:{
                return EncounterType.MERCHANT;
            }
            case 3:{
                return EncounterType.MERCHANT;
            }
            case 4:{
                return EncounterType.GUARD;
            }
            default:
                return EncounterType.EMPTY;
        }
    }

    public void generateRandomAdventure(){

    }
}
