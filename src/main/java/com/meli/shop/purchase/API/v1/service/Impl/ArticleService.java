package com.meli.shop.purchase.API.v1.service.Impl;

import com.meli.shop.purchase.API.v1.DTO.article.ArticlesDTO;
import com.meli.shop.purchase.API.v1.repository.IArticlesRepository;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.service.IArticlesService;
import com.meli.shop.purchase.API.v1.utils.filter.FilterContext;
import com.meli.shop.purchase.API.v1.utils.filter.HighReputationStrategy;
import com.meli.shop.purchase.API.v1.utils.filter.LowReputationStrategy;
import com.meli.shop.purchase.API.v1.utils.filter.ShippingStrategy;
import com.meli.shop.purchase.API.v1.utils.sorter.ISorter;
import com.meli.shop.purchase.API.v1.utils.sorter.MiFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleService implements IArticlesService {
    private final IArticlesRepository iArticlesRepository;

    public ArticleService(IArticlesRepository iArticlesRepository) {
        this.iArticlesRepository = iArticlesRepository;
    }

    @Override
    public ArticlesDTO getArticles(ArticleFilterDTO articleFilterDTO) throws Exception {
        String category = articleFilterDTO.getCategory();
        ArrayList<String> filter = articleFilterDTO.getFilter();
        Integer order = articleFilterDTO.getOrder();

        return new ArticlesDTO((ArrayList<ArticleDTO>) orderArticles(
                filterArticles(
                        filterArticlesByCategory(
                                iArticlesRepository.getAllArticles(),
                                category)
                        , filter), order));
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

    private ArrayList<ArticleDTO> filterArticles(ArrayList<ArticleDTO> articlesDTO, ArrayList<String> filters) {
        if (filters.size() > 0)
            for (String filter : filters) {
                FilterContext filterContext = new FilterContext();
                switch (filter) {
                    case "freeshipping":
                        filterContext.setStrategy(new ShippingStrategy());
                        break;
                    case "highreputation":
                        filterContext.setStrategy(new HighReputationStrategy());
                        break;
                    case "lowreputation":
                        filterContext.setStrategy(new LowReputationStrategy());
                        break;
                }
                articlesDTO = filterContext.filterArticles(articlesDTO, filter);
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
                    Comparator<ArticleDTO> comparatorAsc = (a, b) -> a.getName().compareTo(b.getName());
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorAsc);
                    articlesDTO.clear();
                    for (Object obj : articlesArray) {
                        articlesDTO.add((ArticleDTO) obj);
                    }
                    break;
                case 1:
                    Comparator<ArticleDTO> comparatorDesc = (a, b) -> b.getName().compareTo(a.getName());
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
