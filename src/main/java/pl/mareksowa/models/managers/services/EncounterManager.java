package pl.mareksowa.models.managers.services;
/**
 * Imports section
 */
import org.springframework.stereotype.Service;
import pl.mareksowa.models.EncounterType;

import java.util.Random;

/**
 * Service responsible for every encounter on map
 */
@Service
public class EncounterManager {

    /**
     * Method generate encounter based on game map color field
     * @param fieldColor
     * @return random encounter type
     */
    public EncounterType generateEncounterType(String fieldColor){
        int random = new Random().nextInt(3);
        if (fieldColor.equals("Green")){
            random+=2;
        }
        if (fieldColor.equals("Red")){
            random-=2;
        }
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


}
