package my.dal;

import java.util.ArrayList;
import java.util.List;

public class RepositoryStub implements Repository {
    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for(int i = 1; i <= 504; i++) {
            products.add(new Product(i,"Prod" + i, "Code" + i, 100.0 * i));
        }
        return products;
    }
}
