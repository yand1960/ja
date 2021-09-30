package my.buslog.tests;

import my.buslog.ProductService;
import my.dal.Product;
import my.dal.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTests {

    @Test
    public void testSelectProducts() {
        Repository repository = Mockito.mock(Repository.class);
        List<Product> products = new ArrayList<>();
        Product p = new Product();
        p.setId(123); p.setName("Lala"); p.setCode("AAAA"); p.setPrice(1234.0);
        products.add(p);
        Mockito.when(repository.getAllProducts()).thenReturn(products);
        ProductService service = new ProductService(repository);
        String result = service.selectProducts().get(0).getName();
        Assertions.assertEquals("Lala", result);
    }
}
