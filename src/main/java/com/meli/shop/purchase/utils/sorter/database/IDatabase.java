package com.meli.shop.purchase.utils.sorter.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface IDatabase<T> {
    ArrayList<T> loadDatabase(String path) throws IOException;
}
