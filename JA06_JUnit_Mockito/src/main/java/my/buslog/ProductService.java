package my.buslog;

import my.dal.Product;
import my.dal.Repository;
import my.dal.RepositoryJDBC;

import java.util.List;

public class ProductService {

    private Repository repository;

    public ProductService(Repository repository) {
        this.repository = repository;
    }

    public List<Product> selectProducts() {
        return repository.getAllProducts();
    }

}
