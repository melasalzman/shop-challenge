package com.meli.shop.purchase.utils.sorter;

import java.io.FileReader;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/MiFactory.properties"));
        return Class.forName(properties.getProperty(objName)).getDeclaredConstructor().newInstance();
    }
}
