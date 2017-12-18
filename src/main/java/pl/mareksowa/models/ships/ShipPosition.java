package pl.mareksowa.models.ships;

public class ShipPosition {

    private int layoutX;
    private int layoutY;


    public ShipPosition(int layoutX, int layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public int getLayoutX() {
        return layoutX;
    }

    public void setLayoutX(int layoutX) {
        this.layoutX = layoutX;
    }

    public int getLayoutY() {
        return layoutY;
    }

    public void setLayoutY(int layoutY) {
        this.layoutY = layoutY;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipPosition that = (ShipPosition) o;

        if (layoutX != that.layoutX) return false;
        return layoutY == that.layoutY;
    }

    @Override
    public int hashCode() {
        int result = layoutX;
        result = 31 * result + layoutY;
        return result;
    }
}
