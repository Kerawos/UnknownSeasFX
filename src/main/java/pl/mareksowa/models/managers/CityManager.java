package pl.mareksowa.models.managers;

import org.springframework.stereotype.Service;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.goods.GoodName;

import java.util.List;
/**
 * This service is responsible for all logic connecting with city
 */
@Service
public interface CityManager {

    /**
     * @return all available cities in world map
     */
    List<City> getAllCities();

    /**
     * This method change enum city name to String. THis helps with labels in templates  controllers
     * @param cityName
     * @return
     */
    String convertCityNameToString(CityName cityName);

    /**
     * Method update all goods and their prices
     * @param city
     */
    void updateCityGoods(City city);

    /**
     * Method update all crews member available in the city
     * @param city
     */
    void updateCityCrewTavern(City city);

    /**
     * Method calculate price of given good in the city and more
     * @param goodName
     * @return price of given good
     */
    int priceOf(GoodName goodName);

    /**
     * Method checks if given good existed in the city
     * @param goodName
     * @return good object
     */
    Good getExistedGood(GoodName goodName);

    /**
     * Method calculated price of given good in the current city
     * @param good
     * @return price of good in the city
     */
    int getCitySellPrice(Good good);

    /**
     * Method generate some random price for good in the city
     * @param minPrice lower boundary
     * @param maxPrice upper boundary
     * @return random price
     */
    int generateRandomPriceFromTo(int minPrice, int maxPrice);
}
