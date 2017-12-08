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

}
