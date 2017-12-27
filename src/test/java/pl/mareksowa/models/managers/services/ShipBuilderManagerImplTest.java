package pl.mareksowa.models.managers.services;

import javafx.fxml.FXML;
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
        Ship ship = new Ship();
        ship.setStorageCapacity(5);
        ship.setGold(500);
        Label label;
        assertTrue(shipBuilderManager.canBuyStorage(ship, label));
    }
}