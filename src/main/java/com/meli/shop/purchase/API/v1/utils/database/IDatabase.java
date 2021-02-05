package com.meli.shop.purchase.API.v1.utils.database;

import java.io.IOException;
import java.util.ArrayList;

public interface IDatabase<T> {

    ArrayList loadDatabase(String path, Class typeParameterClass) throws IOException;
}
