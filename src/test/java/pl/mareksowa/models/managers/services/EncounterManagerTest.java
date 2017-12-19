package pl.mareksowa.models.managers.services;

/**
 * Imports section
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.maps.EncounterType;
import pl.mareksowa.models.maps.FieldColor;
import pl.mareksowa.models.maps.MapPosition;
import pl.mareksowa.models.ships.Ship;

import static org.junit.Assert.*;

/**
 * Class responsible for testing encounter manager
 */
public class EncounterManagerTest {

    private static EncounterManager encounterManager;
    
    @BeforeClass public static void setUp() {
        encounterManager = new EncounterManager();
    }

    @AfterClass public static void tearDown() {
        encounterManager = null;
    }

    @Test
    public void testEncounterTypeGenerate() {

    }

    /**
     * Method test if encounters are properly set in case of green field on the map
     */
    @Test public void checkEncounterIfFieldColorIsGreen() {
        Ship shipTest = new Ship();
        shipTest.setMapPosition(new MapPosition(0, 0, FieldColor.GREEN));
        assertNotNull(shipTest);
        EncounterType result;
        boolean isProperType;
        for (int i = 0; i < 33; i++) {
            isProperType = false;
            result = encounterManager.generateEncounterType(shipTest);
            assertNotEquals(result, null);
            if (result==EncounterType.PIRATE || result == EncounterType.MONSTER){
                isProperType = false;
                assertTrue(isProperType);
            }
            if (result==EncounterType.EMPTY
                    || result==EncounterType.ADVENTURE
                    || result==EncounterType.MERCHANT
                    || result==EncounterType.GUARD){
                isProperType = true;
            }
            assertTrue(isProperType);
        }
    }

    /**
     * Method test if encounters are properly set in case of yellow field on the map
     */
    @Test public void checkEncounterIfFieldColorIsYellow() {
        Ship shipTest = new Ship();
        shipTest.setMapPosition(new MapPosition(0, 0, FieldColor.YELLOW));
        assertNotNull(shipTest);
        EncounterType result;
        boolean isProperType;
        for (int i = 0; i < 33; i++) {
            isProperType = false;
            result = encounterManager.generateEncounterType(shipTest);
            assertNotEquals(result, null);
            if (result==EncounterType.PIRATE || result == EncounterType.GUARD){
                isProperType = false;
                assertTrue(isProperType);
            }
            if (result==EncounterType.EMPTY
                    || result==EncounterType.ADVENTURE
                    || result==EncounterType.MERCHANT
                    || result==EncounterType.MONSTER){
                isProperType = true;
            }
            assertTrue(isProperType);
        }
    }

    /**
     * Method test if encounters are properly set in case of red field on the map
     */
    @Test public void checkEncounterIfFieldColorIsRed() {
        Ship shipTest = new Ship();
        shipTest.setMapPosition(new MapPosition(0, 0, FieldColor.RED));
        assertNotNull(shipTest);
        EncounterType result;
        boolean isProperType;
        for (int i = 0; i < 33; i++) {
            isProperType = false;
            result = encounterManager.generateEncounterType(shipTest);
            assertNotEquals(result, null);
            if (result == EncounterType.GUARD){
                isProperType = false;
                assertTrue(isProperType);
            }
            if (result==EncounterType.EMPTY
                    || result==EncounterType.ADVENTURE
                    || result==EncounterType.PIRATE
                    || result==EncounterType.MERCHANT
                    || result==EncounterType.MONSTER){
                isProperType = true;
            }
            assertTrue(isProperType);
        }
    }
}