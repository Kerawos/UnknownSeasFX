package pl.mareksowa.models.goods;

public class Good implements Comparable<Good>{

   private GoodName name;
   private int price;

    public Good(GoodName name, int price) {
        this.name = name;
        this.price = price;
    }

    public Good(GoodName name) {
        this.name = name;
    }

    public GoodName getName() {
        return name;
    }

    public void setName(GoodName name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Good good) {
        return this.getPrice()>good.getPrice()? this.getPrice() : good.getPrice();
    }
}
