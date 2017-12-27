package pl.mareksowa.models.managers.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.SceneNameEquivalent;
import pl.mareksowa.models.managers.SceneManager;
import pl.mareksowa.models.maps.FieldColor;

import static org.junit.Assert.*;

public class SceneManagerImplTest {

    private static SceneManager sceneManager;

    @BeforeClass public static void setUp() {
        sceneManager = new SceneManagerImpl();
    }

    @AfterClass public static void tearDown() {
        sceneManager = null;
    }

    @Test public void testGameTime() {
        assertNotNull(sceneManager.getGameTime());
        assertEquals(1, sceneManager.getGameTime().getDay());
        sceneManager.setGameTime(-5);
        assertEquals(-4, sceneManager.getGameTime().getDay());
    }

    @Test public void testSceneFinder() {
        assertEquals("scenes/tavern.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.TAVERN));
        assertEquals("scenes/armory.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.ARMORY));
        assertEquals("scenes/city.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.CITY));
        assertEquals("scenes/dockyard.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.DOCKYARD));
        assertEquals("scenes/encounter.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.ENCOUNTER));
        assertEquals("scenes/map.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.WORLD_MAP));
        assertEquals("scenes/market.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.MARKET));
        assertEquals("scenes/startPage.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.START_PAGE));
        assertNotEquals("scenes/errorName.fxml", sceneManager.sceneNameFinderByEnum(SceneNameEquivalent.sceneEnumName.START_PAGE));
        try {
            sceneManager.sceneNameFinderByEnum(null);
        } catch (IllegalArgumentException e){
            assertEquals("Map does not contain proper enum name yet..", e.getMessage());
        }
    }
    

}