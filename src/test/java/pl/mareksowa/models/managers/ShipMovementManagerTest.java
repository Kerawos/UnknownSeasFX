package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import pl.mareksowa.models.managers.services.ShipMovementManagerImpl;

import static org.junit.Assert.*;

/**
 * Class will testing all included methods in Movement manager
 */
public class ShipMovementManagerTest {

    private static ShipMovementManager shipMovementManager;

    @BeforeClass public static void setUp() {
        shipMovementManager = new ShipMovementManagerImpl();
    }

    @AfterClass public static void tearDown() {
        shipMovementManager = null;
    }



}