package com.meli.shop.purchase.utils.sorter.database;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;
import com.meli.shop.purchase.Model.Article;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class DatabaseImpl<T> implements IDatabase<T> {

    @Override
    public ArrayList<T> loadDatabase(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ResourceUtils.getFile(path), new TypeReference<>() {
        });
    }
}
