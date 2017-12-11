package pl.mareksowa.models.goods;

public class Good {

   private enum NAME{WHEAT, CLOTHES, WINE, MAHOGANY, DECORATIONS, SILK, SPICES}

   private NAME name;

    public Good(NAME name) {
        this.name = name;
    }

    public NAME getName() {
        return name;
    }

    public void setName(NAME name) {
        this.name = name;
    }
}
