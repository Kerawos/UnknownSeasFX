package pl.mareksowa.models.ships;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StartingShipTest {

    private static StartingShip startingShip;

    @BeforeClass public static void start(){
        startingShip = new StartingShip();
    }

    @AfterClass public static void stop() throws Exception {
        startingShip = null;
    }

    @Test public void testStartingShipGenerator() throws Exception {
        assertNotNull(startingShip.getStartingShip());
        Ship testShip = new Ship(1,1,1,100,100,1,100,5,0);
        assertEquals(testShip.toString(), startingShip.getStartingShip().toString());
    }
}