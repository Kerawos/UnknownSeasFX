package pl.mareksowa.models.functionalities.services;

import pl.mareksowa.models.cities.*;
import pl.mareksowa.models.functionalities.CityFunctionality;
import pl.mareksowa.models.goods.Good;
import pl.mareksowa.models.goods.GoodName;

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
    public void updateCityGoods(City city) {
        List<Good> goodList = new ArrayList<>();
        int priceTemp = generateRandom(1, 3) + city.getWheatRequest();
        goodList.add(new Good(GoodName.WHEAT, priceTemp>0?priceTemp:1));
        priceTemp = generateRandom(2, 4) + city.getClothesRequest();
        goodList.add(new Good(GoodName.CLOTHES, priceTemp>0?priceTemp:1));
        goodList.add(new Good(GoodName.WINE, generateRandom(3, 5) + city.getWineRequest()));
        goodList.add(new Good(GoodName.MAHOGANY, generateRandom(4, 6) + city.getMahoganyRequest()));
        goodList.add(new Good(GoodName.DECORATIONS, generateRandom(5, 7) + city.getDecorationsRequest()));
        goodList.add(new Good(GoodName.SILK, generateRandom(6, 8) + city.getSilkRequest()));
        goodList.add(new Good(GoodName.SPICES, generateRandom(7, 9) + city.getSpicesRequest()));
        city.setGoodList(goodList);
    }

    @Override
    public int priceOf(GoodName goodName){
        List<Good> goodList = SceneManager.getInstance().getCURRENT_CITY().getGoodList();
        for (int i = 0; i < goodList.size(); i++) {
            if (goodList.get(i).getName()==goodName){
                return goodList.get(i).getPrice();
            }
        }
        return 999;
    }

    @Override
    public Good getExistedGood(GoodName goodName) {
        for (Good good : SceneManager.getInstance().getCURRENT_CITY().getGoodList()) {
            if (good.getName()==goodName){
                return good;
            }
        }
        return null;
    }

    @Override
    public int getCitySellPrice(Good good) {
        for (Good g : SceneManager.getInstance().getCURRENT_CITY().getGoodList()) {
            if (g.getName().equals(good.getName())){
                return g.getPrice();
            }
        }
        System.out.println("towaru nie znalezniono");
        return 999;
    }

    private int generateRandom(int min, int max){
        return new Random().nextInt(max-min)+min;
    }
}
