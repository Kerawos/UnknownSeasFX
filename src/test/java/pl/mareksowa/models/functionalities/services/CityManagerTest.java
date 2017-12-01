package pl.mareksowa.models.functionalities.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.cities.CityName;

import static org.junit.Assert.*;

public class CityManagerTest {

    private static CityManager cityManager;

    @BeforeClass public static void start() {
        cityManager = new CityManager();
    }

    @AfterClass public static void stop() throws Exception {
        cityManager = null;
    }

    @Test public void testConvertEnumToString() throws Exception {
        String expected = "CENTEROS";
        String actual = cityManager.convertCityNameToString(CityName.CENTEROS);
        assertEquals(expected, actual);
    }
}