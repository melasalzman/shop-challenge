package com.meli.shop.purchase.utils.sorter;

import java.util.Comparator;

public interface ISorter<T> {
    public T[] sort(T arr[], Comparator<T> c);
}
