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
        Label label = new Label();
        try{
            shipBuilderManager.canBuyStorage(ship, label);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "There is no more space in the ship");
        }


    }
}
