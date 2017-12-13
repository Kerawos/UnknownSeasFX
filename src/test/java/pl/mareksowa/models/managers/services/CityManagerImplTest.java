package pl.mareksowa.models.managers.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.cities.CityName;

import static org.junit.Assert.*;

public class CityManagerImplTest {

    private static CityManagerImpl cityManagerImpl;

    @BeforeClass public static void start() {
        cityManagerImpl = new CityManagerImpl();
    }

    @AfterClass public static void stop() throws Exception {
        cityManagerImpl = null;
    }

    @Test public void testConvertEnumToString() throws Exception {
        String expected = "CENTEROS";
        String actual = cityManagerImpl.convertCityNameToString(CityName.CENTEROS);
        assertEquals(expected, actual);
    }
}