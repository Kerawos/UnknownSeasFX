package pl.mareksowa.models.maps;

/**
 * Class responsible for holding position on the map
 */
public class MapPosition {

    /**
     * Variables declaration
     */
    private int layoutX;
    private int layoutY;
    private FieldColor fieldColor;

    /**
     * Constructors
     * @param layoutX
     * @param layoutY
     */
    public MapPosition(int layoutX, int layoutY) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
    }

    public MapPosition(int layoutX, int layoutY, FieldColor fieldColor) {
        this.layoutX = layoutX;
        this.layoutY = layoutY;
        this.fieldColor = fieldColor;
    }

    /**
     * Getters and setters
     */
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

        MapPosition that = (MapPosition) o;

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
