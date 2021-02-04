package com.meli.shop.purchase.service.Impl;

import com.meli.shop.purchase.DTO.Request.ArticleFilterDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;
import com.meli.shop.purchase.repository.IArticlesRepository;
import com.meli.shop.purchase.service.IArticlesService;
import com.meli.shop.purchase.utils.sorter.ISorter;
import com.meli.shop.purchase.utils.sorter.MiFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleService implements IArticlesService {
    @Autowired
    private IArticlesRepository iArticlesRepository;

    @Override
    public ArrayList<ArticleDTO> getArticles(ArticleFilterDTO articleFilterDTO) throws Exception {
        ArrayList<ArticleDTO> articles = new ArrayList<>();
        String category = articleFilterDTO.getCategory();
        String filter = articleFilterDTO.getFilter();
        Integer order = articleFilterDTO.getOrder();

        return (ArrayList<ArticleDTO>) orderArticles(
                filterArticles(
                        filterArticlesByCategory(
                                iArticlesRepository.getAllArticles(),
                                category)
                        , filter), order);
    }

    private ArrayList<ArticleDTO> filterArticlesByCategory(ArrayList<ArticleDTO> articlesDTO, String category) {
        if (category != null) {
            articlesDTO = (ArrayList<ArticleDTO>) articlesDTO.stream()
                    .filter(article ->
                            article.getCategory()
                                    .toLowerCase(Locale.ROOT)
                                    .equals(category.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
        }
        return articlesDTO;
    }

    private ArrayList<ArticleDTO> filterArticles(ArrayList<ArticleDTO> articlesDTO, String filter) {
        if (filter != null) {
            switch (filter.toLowerCase(Locale.ROOT)) {
                case "freeshipping":
                    articlesDTO = (ArrayList<ArticleDTO>) articlesDTO.stream()
                            .filter(article -> article.getFreeShipping() == true).collect(Collectors.toList());
                    break;
            }
        }
        return articlesDTO;
    }

    private List<ArticleDTO> orderArticles(ArrayList<ArticleDTO> articlesDTO, Integer order) throws Exception {
        MiFactory factory = new MiFactory();
        ISorter object = (ISorter) factory.getInstance("sorter");
        Object[] articlesArray;
        if (order != null) {
            switch (order) {
                case 0:
                    Comparator<ArticleDTO> comparatorAsc = (a,b) -> a.getName().compareTo(b.getName());
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorAsc);
                    articlesDTO.clear();
                    for (Object obj : articlesArray) {
                        articlesDTO.add((ArticleDTO) obj);
                    }
                    break;
                case 1:
                    Comparator<ArticleDTO> comparatorDesc = (a,b) -> b.getName().compareTo(a.getName());
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorDesc);
                    articlesDTO.clear();
                    for (Object obj : articlesArray) {
                        articlesDTO.add((ArticleDTO) obj);
                    }
                    break;
                case 2:
                    Comparator<ArticleDTO> comparatorPriceAsc = (a, b) -> (int) (b.getPrice() - a.getPrice());
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorPriceAsc);
                    articlesDTO.clear();
                    for (Object obj : articlesArray) {
                        articlesDTO.add((ArticleDTO) obj);
                    }
                    break;
                case 3:
                    Comparator<ArticleDTO> comparatorPriceDesc = (a, b) -> (int) (a.getPrice() - b.getPrice());
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorPriceDesc);
                    articlesDTO.clear();
                    for (Object obj : articlesArray) {
                        articlesDTO.add((ArticleDTO) obj);
                    }
                    break;
            }
        }
        return articlesDTO;
    }

}
