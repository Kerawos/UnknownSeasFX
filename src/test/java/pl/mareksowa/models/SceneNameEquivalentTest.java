package pl.mareksowa.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mareksowa.models.managers.CityManager;
import pl.mareksowa.models.managers.SceneManager;
import pl.mareksowa.models.managers.services.SceneManagerImpl;

import static org.junit.Assert.*;

public class SceneNameEquivalentTest {

    private static SceneNameEquivalent sceneNameEquivalent;

    @BeforeClass public static void start() {
        sceneNameEquivalent = new SceneNameEquivalent();
    }

    @AfterClass public static void stop() throws Exception {
        sceneNameEquivalent = null;
    }

    SceneManager sceneManager = new SceneManagerImpl();
    @Autowired CityManager cityManager;

    @Test public void testProperMapBehaviour() throws Exception {
        assertNotNull(sceneManager);
        assertNotNull(cityManager);
        assertNotNull(sceneNameEquivalent.getSceneNameMap());
        assertEquals("scenes/city.fxml", sceneNameEquivalent.getSceneNameMap().get(SceneNameEquivalent.sceneEnumName.CITY));
        assertEquals("scenes/dockyard.fxml", sceneNameEquivalent.getSceneNameMap().get(SceneNameEquivalent.sceneEnumName.DOCKYARD));
    }
}