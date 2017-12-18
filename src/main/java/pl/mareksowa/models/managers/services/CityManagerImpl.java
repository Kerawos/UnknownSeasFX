package pl.mareksowa.models.managers.services;

/**
 * Import sections
 */

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.mareksowa.models.CurrentScene;
import pl.mareksowa.models.cities.*;
import pl.mareksowa.models.crews.Crew;
import pl.mareksowa.models.managers.CityManager;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.goods.GoodName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This service is responsible for all logic connecting with city
 */
@Repository
public class CityManagerImpl implements CityManager {

    /**
     * Container for available city
     */
    private List<City> cities;

    /**
     * Constructor with initializator of cities available in the game
     */
    public CityManagerImpl() {
        generateAvailableCities();
    }

    /**
     * Method will generate all cities available in the game
     * @return all cities
     */
    private List<City> generateAvailableCities(){
        cities = new ArrayList<>();
        cities.add(new GothShai());
        cities.add(new Masumba());
        cities.add(new MilaDoce());
        cities.add(new Balados());
        cities.add(new Centeros());
        cities.add(new Zihlu());
        return cities;
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
    public void updateCityGoods(City city) {
        List<Good> goodList = new ArrayList<>();
        int priceTemp = generateRandomPriceFromTo(1, 3) + city.getWheatRequest();
        goodList.add(new Good(GoodName.WHEAT, priceTemp>0?priceTemp:1));
        priceTemp = generateRandomPriceFromTo(2, 4) + city.getClothesRequest();
        goodList.add(new Good(GoodName.CLOTHES, priceTemp>0?priceTemp:1));
        goodList.add(new Good(GoodName.WINE, generateRandomPriceFromTo(3, 5) + city.getWineRequest()));
        goodList.add(new Good(GoodName.MAHOGANY, generateRandomPriceFromTo(4, 6) + city.getMahoganyRequest()));
        goodList.add(new Good(GoodName.DECORATIONS, generateRandomPriceFromTo(5, 7) + city.getDecorationsRequest()));
        goodList.add(new Good(GoodName.SILK, generateRandomPriceFromTo(6, 8) + city.getSilkRequest()));
        goodList.add(new Good(GoodName.SPICES, generateRandomPriceFromTo(7, 9) + city.getSpicesRequest()));
        city.setGoodList(goodList);
    }

    @Override
    public void updateCityCrewTavern(City city) {
        city.setCrewTavernList(CurrentScene.getInstance().getShipCrewManager().generateTavernList(4));
    }

    @Override
    public void removeCityCrewMember(City city, int crewListNo) {
        
    }

    @Override
    public int priceOf(GoodName goodName){
        List<Good> goodList = CurrentScene.getInstance().getCurrentCity().getGoodList();
        for (int i = 0; i < goodList.size(); i++) {
            if (goodList.get(i).getName()==goodName){
                return goodList.get(i).getPrice();
            }
        }
        return 999;
    }

    @Override
    public Good getExistedGood(GoodName goodName) {
        for (Good good : CurrentScene.getInstance().getCurrentCity().getGoodList()) {
            if (good.getName()==goodName){
                return good;
            }
        }
        return null;
    }

    @Override
    public int getCitySellPrice(Good good) {
        for (Good g : CurrentScene.getInstance().getCurrentCity().getGoodList()) {
            if (g.getName().equals(good.getName())){
                return g.getPrice();
            }
        }
        System.out.println("towaru nie znalezniono");
        return 999;
    }

    @Override
    public int generateRandomPriceFromTo(int minPrice, int maxPrice){
        return new Random().nextInt(maxPrice - minPrice) + minPrice;
    }
}
