package pl.mareksowa.models.managers.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.cities.Centeros;
import pl.mareksowa.models.cities.City;
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

    @Test public void testCityGoods() {
        City city = new Centeros();
        assertNull(city.getGoodList());
        cityManagerImpl.updateCityGoods(city);
        assertNotNull(city.getGoodList());
        assertEquals(city.getGoodList().size(), 7);
        for (int i = 0; i < city.getGoodList().size(); i++) {
           assertTrue(checkIfInRange(city.getGoodList().get(i).getPrice(), i));
        }
    }
    private boolean checkIfInRange(int price, int range){
        if (price<range || price>range+2){
            return false;
        }
        return true;
    }
}