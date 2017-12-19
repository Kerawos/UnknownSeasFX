package pl.mareksowa.models.managers;

/**
 * Imports section
 */
import javafx.scene.image.ImageView;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.managers.services.ShipMovementManagerImpl;
import pl.mareksowa.models.ships.Ship;

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

    /**
     * Method will test if ship can move
     */
    @Test public void testShipMovePotential() {
        Ship shipTest = new Ship();
        shipTest.setMovePossibility(5);
        assertEquals(5, shipMovementManager.getRemainShipMove(shipTest));
        shipMovementManager.updateShipMove(shipTest, 3);
        assertEquals(2, shipMovementManager.getRemainShipMove(shipTest));
        assertTrue(shipMovementManager.canShipMove(shipTest, 1));
        assertFalse(shipMovementManager.canShipMove(shipTest, -51));
        assertFalse(shipMovementManager.canShipMove(shipTest, 0));
        try{
            shipMovementManager.canShipMove(null, 0);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Ship cannot be null", e.getMessage());
        }
        assertFalse(shipMovementManager.canShipMove(shipTest, 51));
    }

    /**
     * Method test proper movement of the ship
     */
    @Test public void testShipMoving() {
        Ship shipTest = new Ship();
        shipTest.setMapPosition(shipMovementManager.getPositionField1());
        shipMovementManager.moveShipTo(shipTest, shipMovementManager.getPositionField2(), new ImageView());
        assertEquals(shipMovementManager.getPositionField2(), shipTest.getMapPosition());
        shipMovementManager.moveShipToFast(shipTest, shipMovementManager.getPositionField6(), new ImageView());
        assertEquals(shipMovementManager.getPositionField6(), shipTest.getMapPosition());
        shipMovementManager.setHardShipPosition(shipTest, shipMovementManager.getPositionField11(), new ImageView());
        assertEquals(shipMovementManager.getPositionField11(), shipTest.getMapPosition());

        try{
            shipMovementManager.moveShipToFast(null, shipMovementManager.getPositionField6(), new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.moveShipToFast(new Ship(), null, new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.moveShipToFast(new Ship(), shipMovementManager.getPositionField6(), null);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.moveShipTo(null, shipMovementManager.getPositionField6(), new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.moveShipTo(new Ship(), null, new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.moveShipTo(new Ship(), shipMovementManager.getPositionField6(), null);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.setHardShipPosition(null, shipMovementManager.getPositionField6(), new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.setHardShipPosition(new Ship(), null, new ImageView());
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
        try{
            shipMovementManager.setHardShipPosition(new Ship(), shipMovementManager.getPositionField6(), null);
            fail("exc not catch");
        } catch (IllegalArgumentException e){
            assertEquals("Arguments cannot be null", e.getMessage());
        }
    }

    /**
     * Method will test possibility to entering the city
     */
    @Test public void testProperMoveOnTheMap() {
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField1(), shipMovementManager.getPositionField2()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField2(), shipMovementManager.getPositionField3()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField3(), shipMovementManager.getPositionField2()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField4(), shipMovementManager.getPositionField5()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField5(), shipMovementManager.getPositionField4()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField6(), shipMovementManager.getPositionField5()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField7(), shipMovementManager.getPositionField6()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField8(), shipMovementManager.getPositionField7()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField9(), shipMovementManager.getPositionField8()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField10(), shipMovementManager.getPositionField9()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField11(), shipMovementManager.getPositionField10()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField12(), shipMovementManager.getPositionField11()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField13(), shipMovementManager.getPositionField12()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField14(), shipMovementManager.getPositionField13()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField15(), shipMovementManager.getPositionField14()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField16(), shipMovementManager.getPositionField15()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField17(), shipMovementManager.getPositionField16()));
        //special moves
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField7(), shipMovementManager.getPositionField15()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField15(), shipMovementManager.getPositionField7()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField13(), shipMovementManager.getPositionField16()));
        assertTrue(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField16(), shipMovementManager.getPositionField13()));

        assertFalse(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField16(), shipMovementManager.getPositionField11()));
        assertFalse(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField16(), shipMovementManager.getPositionField1()));
        assertFalse(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField2(), shipMovementManager.getPositionField5()));
        assertFalse(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField4(), shipMovementManager.getPositionField1()));
        assertFalse(shipMovementManager.isMoveAllowed(shipMovementManager.getPositionField1(), shipMovementManager.getPositionField17()));


    }
}