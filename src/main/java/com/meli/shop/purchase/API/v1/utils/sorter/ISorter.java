package com.meli.shop.purchase.API.v1.utils.sorter;

import java.util.Comparator;

public interface ISorter<T> {
    public T[] sort(T arr[], Comparator<T> c);
}
