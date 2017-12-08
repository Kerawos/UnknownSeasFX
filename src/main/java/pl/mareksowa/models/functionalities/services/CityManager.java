package pl.mareksowa.models.functionalities.services;

import pl.mareksowa.models.cities.*;
import pl.mareksowa.models.functionalities.CityFunctionality;

import java.util.ArrayList;
import java.util.List;

public class CityManager implements CityFunctionality {

    private List<City> cities;

    public CityManager() {
        cities = new ArrayList<>();
        cities.add(new GothShai());
        cities.add(new Masumba());
        cities.add(new MilaDoce());
        cities.add(new Balados());
        cities.add(new Centeros());
        cities.add(new Zihlu());
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
