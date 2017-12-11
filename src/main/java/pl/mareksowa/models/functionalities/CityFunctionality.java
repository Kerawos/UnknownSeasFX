package pl.mareksowa.models.functionalities;

import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.goods.GoodName;

import java.util.List;

public interface CityFunctionality {
    List<City> getAllCities();
    String convertCityNameToString(CityName cityName);
    void updateCityGoods(City city);
    int priceOf(GoodName goodName);
    Good getExistedGood(GoodName goodName);
}
