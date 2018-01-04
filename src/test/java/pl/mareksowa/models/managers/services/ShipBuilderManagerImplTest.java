package pl.mareksowa.models.managers.services;

import javafx.scene.control.Label;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.managers.ShipBuilderManager;
import pl.mareksowa.models.ships.Ship;

import static org.junit.Assert.*;

public class ShipBuilderManagerImplTest {

    private static ShipBuilderManager shipBuilderManager;

    @BeforeClass public static void setUp() {
        shipBuilderManager = new ShipBuilderManagerImpl();
    }

    @AfterClass public static void tearDown() {
        shipBuilderManager= null;
    }

    @Test public void testStorageManagement() {
        assertEquals(0, new Ship().getStorageCapacity());
        Ship ship = new Ship();
        assertTrue(shipBuilderManager.canBuyStorage(ship, null));
        ship.setStorageCapacity(9);
        ship.setGold(500);
        assertEquals(9, ship.getStorageCapacity());
        shipBuilderManager.addStorage(ship);
        assertEquals(10, ship.getStorageCapacity());
        try {
            shipBuilderManager.addStorage(null);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Ship cannot be null");
        }
        assertEquals(410, ship.getGold());
        assertEquals(0, ship.getCannonCapacity());
        shipBuilderManager.addCannonSpace(ship);
        assertEquals(1, ship.getCannonCapacity());
        assertEquals(405, ship.getGold());
        assertEquals(0, ship.getCabinCapacity());
        shipBuilderManager.addCabin(ship);
        assertEquals(1, ship.getCabinCapacity());
        assertEquals(404, ship.getGold());
        assertEquals(0, ship.getSailCapacity());
        shipBuilderManager.addSailSpace(ship);
        assertEquals(1, ship.getSailCapacity());
        assertEquals(394, ship.getGold());
        assertEquals(0, ship.getCurrentEndurance());
        shipBuilderManager.repair(ship, 25);
        assertEquals(25, ship.getCurrentEndurance());
        assertEquals(369, ship.getGold());
    }

    @Test
    public void testCanBuy() {
        Ship ship = new Ship();
        Label label = new Label();
        try{
            shipBuilderManager.canBuyStorage(ship, label);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "There is no more space in the ship");
        }
    }
}
