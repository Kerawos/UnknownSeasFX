package pl.mareksowa.models.managers.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.mareksowa.models.cities.Centeros;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.crews.NoOne;

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
        for (int i = 0; i < 99; i++) {
            city.setWineRequest(1);
            city.setWheatRequest(1);
            city.setDecorationsRequest(1);
            cityManagerImpl.updateCityGoods(city);
            for (int j = 0; j < city.getGoodList().size(); j++) {
                assertTrue(checkIfInRange(city.getGoodList().get(j).getPrice(), j+1));
            }
        }
        try{
            cityManagerImpl.updateCityGoods(null);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "City cannot be null");
        }
    }
    private boolean checkIfInRange(int price, int range){
        if (price<range || price>range+2){
            return false;
        }
        return true;
    }

    @Test public void testCrewCityMember() {
        City city = new Centeros();
        assertNull(city.getCrewTavernList());
        cityManagerImpl.updateCityCrewTavern(city);
        assertNotNull(city.getCrewTavernList());
        for (int i = 0; i < 4; i++) {
            cityManagerImpl.removeCityCrewMember(city, i);
            assertEquals(city.getCrewTavernList().get(i).toString(), new NoOne().toString());
        }
        try{
            cityManagerImpl.updateCityCrewTavern(null);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "City cannot be null");
        }
        try{
            cityManagerImpl.removeCityCrewMember(null, 23);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "City cannot be null");
        }
        try{
            cityManagerImpl.removeCityCrewMember(city, 23);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Crew number out of range");
        }
        try{
            cityManagerImpl.removeCityCrewMember(city, -923);
        } catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Crew number out of range");
        }
    }
}