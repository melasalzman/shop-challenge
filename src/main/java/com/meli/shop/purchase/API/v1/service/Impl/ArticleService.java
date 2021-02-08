package com.meli.shop.purchase.API.v1.service.Impl;

import com.meli.shop.purchase.API.v1.DTO.article.ArticlesDTO;
import com.meli.shop.purchase.API.v1.exception.article.InvalidArgumentException;
import com.meli.shop.purchase.API.v1.exception.article.NoDataFoundException;
import com.meli.shop.purchase.API.v1.repository.IArticlesRepository;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.service.IArticlesService;
import com.meli.shop.purchase.API.v1.utils.filter.*;
import com.meli.shop.purchase.API.v1.utils.sorter.ISorter;
import com.meli.shop.purchase.API.v1.utils.sorter.SorterFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ArticleService<T> implements IArticlesService {
    private final IArticlesRepository iArticlesRepository;

    public ArticleService(IArticlesRepository iArticlesRepository) {
        this.iArticlesRepository = iArticlesRepository;
    }

    @Override
    public ArticlesDTO getArticles(ArticleFilterDTO articleFilterDTO) throws NoDataFoundException, Exception {
        String category = articleFilterDTO.getCategory();
        Double expensivePricesThan = articleFilterDTO.getExpensivePricesThan();
        Double cheaperPricesThan = articleFilterDTO.getCheaperPricesThan();
        String name = articleFilterDTO.getName();
        String brand = articleFilterDTO.getBrand();
        Integer quantity = articleFilterDTO.getQuantity();
        String shippingType = articleFilterDTO.getShippingType();
        Boolean featured = articleFilterDTO.getFeatured();
        Boolean arrivesTomorrow = articleFilterDTO.getArrivesTomorrow();
        Boolean withoutInterest = articleFilterDTO.getWithoutInterest();
        String condition = articleFilterDTO.getCondition();
        ArrayList<String> filters = articleFilterDTO.getFilter();
        Integer order = articleFilterDTO.getOrder();

        HashMap<String, String> attributes = new HashMap<>();
        if (articleFilterDTO.getCategory() != null) attributes.put("category", category);
        if (expensivePricesThan != null) attributes.put("expensivepricesthan", String.valueOf(expensivePricesThan));
        if (cheaperPricesThan != null) attributes.put("cheaperpricesthan", String.valueOf(cheaperPricesThan));
        if (name != null) attributes.put("name", name);
        if (brand != null) attributes.put("brand", brand);
        if (quantity != null) attributes.put("quantity", String.valueOf(quantity));
        if (shippingType != null) attributes.put("shippingtype", shippingType);
        if (featured != null) attributes.put("featured", String.valueOf(featured));
        if (arrivesTomorrow != null) attributes.put("arrivestomorrow", String.valueOf(arrivesTomorrow));
        if (withoutInterest != null) attributes.put("withoutinterest", String.valueOf(withoutInterest));
        if (condition != null) attributes.put("condition", condition);
        if (filters != null) {
            for (String filter : filters) {
                attributes.put(filter, null);
            }
        }

        ArrayList<ArticleDTO> articles = iArticlesRepository.getAllArticles();

        if (articles.isEmpty()||articles==null) {
            throw new NoDataFoundException("No se encontraron artículos");
        }

        return new ArticlesDTO((ArrayList<ArticleDTO>) orderArticles(filterArticles(articles, attributes), order));
    }

    private ArrayList<ArticleDTO> filterArticles(ArrayList<ArticleDTO> articlesDTO, HashMap<String, String> filters) {
        if (filters != null) {
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                articlesDTO = (ArrayList<ArticleDTO>) articlesDTO.stream().filter(article ->
                        setFilterCondition(article, entry))
                        .collect(Collectors.toList());
            }
        }
        return articlesDTO;
    }

    private Boolean setFilterCondition(ArticleDTO articleDTO, Map.Entry<String, String> entry) {
        FilterContext filterContext = new FilterContext();
        String value = entry.getValue();
        Boolean filterCondition = false;
        switch (entry.getKey().toLowerCase(Locale.ROOT)) {
            case "sendfree":
                filterContext.setStrategy(new BooleanStrategy());
                filterCondition = filterContext.filter(articleDTO.getFreeShipping(), "true");
                break;
            case "highreputation":
                filterContext.setStrategy(new HighEqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getReputation(), "3");
                break;
            case "lowreputation":
                filterContext.setStrategy(new LowEqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getReputation(), "3");
                break;
            case "category":
                filterContext.setStrategy(new EqualNameStrategy());
                filterCondition = filterContext.filter(articleDTO.getCategory(), value);
                break;
            case "name":
                filterContext.setStrategy(new ContainsNameStrategy());
                filterCondition = filterContext.filter(articleDTO.getName(), value);
                break;
            case "brand":
                filterContext.setStrategy(new ContainsNameStrategy());
                filterCondition = filterContext.filter(articleDTO.getBrand(), value);
                break;
            case "expensivepricesthan":
                filterContext.setStrategy(new HighEqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getPrice(), value);
                break;
            case "cheaperpricesthan":
                filterContext.setStrategy(new LowEqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getPrice(), value);
                break;
            case "equalprice":
                filterContext.setStrategy(new EqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getPrice(), value);
                break;
            case "higherquantity":
                filterContext.setStrategy(new HighEqualNumberStrategy());
                filterCondition = filterContext.filter(articleDTO.getPrice(), value);
                break;
            case "shippingtype":
                filterContext.setStrategy(new EqualNameStrategy());
                filterCondition = filterContext.filter(articleDTO.getShippingType(), value);
                break;
            case "featured":
                filterContext.setStrategy(new BooleanStrategy());
                filterCondition = filterContext.filter(articleDTO.getFeatured(), value);
                break;
            case "arrivestomorrow":
                filterContext.setStrategy(new BooleanStrategy());
                filterCondition = filterContext.filter(articleDTO.getArrivesTomorrow(), value);
                break;
            case "withoutinterest":
                filterContext.setStrategy(new BooleanStrategy());
                filterCondition = filterContext.filter(articleDTO.getWithoutInterest(), value);
                break;
            case "condition":
                filterContext.setStrategy(new EqualNameStrategy());
                filterCondition = filterContext.filter(articleDTO.getCondition(), value);
                break;
            case "default":
                throw new InvalidArgumentException("No existe el filtro que estas ingresando");
        }

        return filterCondition;
    }


    private List<ArticleDTO> orderArticles(ArrayList<ArticleDTO> articlesDTO, Integer order) throws Exception {
        if (order != null) {
            Comparator<ArticleDTO> comparatorAsc = (a, b) -> a.getName().compareTo(b.getName());
            Comparator<ArticleDTO> comparatorDesc = (a, b) -> b.getName().compareTo(a.getName());
            Comparator<ArticleDTO> comparatorPriceAsc = (a, b) -> (int) (b.getPrice() - a.getPrice());
            Comparator<ArticleDTO> comparatorPriceDesc = (a, b) -> (int) (a.getPrice() - b.getPrice());

            SorterFactory factory = new SorterFactory();
            ISorter object = (ISorter) factory.getInstance("sorter");
            Object[] articlesArray = new Object[0];

            switch (order) {
                case 0:
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorAsc);
                    break;
                case 1:
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorDesc);
                    break;
                case 2:
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorPriceAsc);
                    break;
                case 3:
                    articlesArray = object.sort(articlesDTO.toArray(), comparatorPriceDesc);
                    break;
            }
            articlesDTO.clear();
            for (Object obj : articlesArray) {
                articlesDTO.add((ArticleDTO) obj);
            }
        }
        return articlesDTO;
    }

}
