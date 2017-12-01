package pl.mareksowa.models.functionalities.services;

import pl.mareksowa.models.cities.Centeros;
import pl.mareksowa.models.cities.City;
import pl.mareksowa.models.cities.CityName;
import pl.mareksowa.models.functionalities.CityFunctionality;

import java.util.ArrayList;
import java.util.List;

public class CityManager implements CityFunctionality {

    private List<City> cities;

    public CityManager() {
        cities = new ArrayList<>();
        cities.add(new Centeros());
    }

    @Override
    public List<City> getAllCities() {
        return cities;
    }


    @Override
    public void updateCity(City city) {

    }

    @Override
    public String convertCityNameToString(CityName cityName) {
        String result;
        result = String.valueOf(cityName);
        return result;
    }
}
