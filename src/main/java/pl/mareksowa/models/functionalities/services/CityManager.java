package pl.mareksowa.models.functionalities.services;

import pl.mareksowa.models.Price;
import pl.mareksowa.models.cities.*;
import pl.mareksowa.models.functionalities.CityFunctionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public String convertCityNameToString(CityName cityName) {
        String result;
        result = String.valueOf(cityName);
        return result;
    }

    @Override
    public Price generatePrices(City city) {
        Price result = new Price();
        result.setFood(generateRandom(1, 2) + city.getFoodRequest());
        result.setWheat(generateRandom(1, 5) + city.getWheatRequest());
        result.setClothes(generateRandom(2, 6) + city.getClothesRequest());
        result.setWine(generateRandom(3, 7) + city.getWineRequest());
        result.setMahogany(generateRandom(4, 8) + city.getMahoganyRequest());
        result.setDecorations(generateRandom(5, 9) + city.getDecorationsRequest());
        result.setSilk(generateRandom(6, 11) + city.getSilkRequest());
        result.setSpices(generateRandom(7, 13) + city.getSpicesRequest());
        return result;
    }

    @Override
    public void updatePrices(City city) {
        city.setPrices(generatePrices(city));
    }

    private int generateRandom(int min, int max){
        return new Random().nextInt(max-min)+min;
    }
}
