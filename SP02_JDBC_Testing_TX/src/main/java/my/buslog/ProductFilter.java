package my.buslog;

import my.dal.Product;
import my.dal.Repository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component("filter")
public class ProductFilter {

    List<Product> allProducts;

    public ProductFilter(Repository repository) {
        allProducts = repository.getProducts();
    }

    public List<Product> filterByFirstLetters(String letters) {
        return allProducts
                .stream()
                .filter(p ->
                        p.getName()
                                .toLowerCase()
                                .indexOf(letters.toLowerCase())== 0)
                .collect(Collectors.toList());
    }
}
