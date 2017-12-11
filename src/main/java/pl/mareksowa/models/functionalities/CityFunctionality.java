package pl.mareksowa.models.functionalities;

import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;

import java.util.List;

public interface CityFunctionality {
    List<City> getAllCities();
    String convertCityNameToString(CityName cityName);
    void updateCityGoods(City city);
}
