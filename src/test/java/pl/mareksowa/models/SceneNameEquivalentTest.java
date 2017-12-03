package pl.mareksowa.models;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SceneNameEquivalentTest {

    private static SceneNameEquivalent sceneNameEquivalent;

    @BeforeClass public static void start() {
        sceneNameEquivalent = new SceneNameEquivalent();
    }

    @AfterClass public static void stop() throws Exception {
        sceneNameEquivalent = null;
    }

    @Test public void testProperMapBehaviour() throws Exception {
        assertNotNull(sceneNameEquivalent.getSceneNameMap());
        assertEquals("scenes/city.fxml", sceneNameEquivalent.getSceneNameMap().get(SceneNameEquivalent.sceneEnumName.CITY));
        assertEquals("scenes/dockyard.fxml", sceneNameEquivalent.getSceneNameMap().get(SceneNameEquivalent.sceneEnumName.DOCKYARD));
    }
}