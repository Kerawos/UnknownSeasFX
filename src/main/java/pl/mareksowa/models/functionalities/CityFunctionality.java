package pl.mareksowa.models.functionalities;

import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;

import java.util.List;

public interface CityFunctionality {
    List<City> getAllCities();
    void updateCity(City city);
    String convertCityNameToString(CityName cityName);
}
