package pl.multishop.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.multishop.domain.Product;

/**
 * Created by michal on 05.05.17.
 */

public interface ProductRepository // Interfejs warstwy danych
{
    List <Product> getAllProducts();

    Product getProductById(String productID);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
