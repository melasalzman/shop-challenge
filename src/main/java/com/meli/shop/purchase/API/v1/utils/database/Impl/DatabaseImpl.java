package com.meli.shop.purchase.API.v1.utils.database.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DatabaseImpl<T> implements IDatabase<T> {

    @Override
    public ArrayList<T> loadDatabase(String path, Class typeParameterClass) throws IOException {
        String json = readFileAsString(path);
        return (ArrayList<T>) jsonArrayToObjectList(json, typeParameterClass);
    }

    private String readFileAsString(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get(file)));
    }

    public <T> List<T> jsonArrayToObjectList(String json, Class<T> tClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, tClass);
        List<T> ts = mapper.readValue(json, listType);
        return ts;
    }
}
