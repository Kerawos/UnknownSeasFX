package pl.mareksowa.models.managers.services;

import pl.mareksowa.models.goods.Good;

import java.util.Comparator;

public class ComparatorGoods implements Comparator<Good> {

    @Override
    public int compare(Good o1, Good o2) {
        return o1.compareTo(o2);
    }
}
