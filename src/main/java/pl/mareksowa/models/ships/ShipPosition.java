package pl.mareksowa.models.ships;

import pl.mareksowa.models.FieldColor;

public class ShipPosition {

    private int layoutX;
    private int layoutY;
    private FieldColor fieldColor;

    public ShipPosition(int layoutX, int layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public ShipPosition(int layoutX, int layoutY, FieldColor fieldColor) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
        this.fieldColor = fieldColor;
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

    public FieldColor getFieldColor() {
        return fieldColor;
    }

    public void setFieldColor(FieldColor fieldColor) {
        this.fieldColor = fieldColor;
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
