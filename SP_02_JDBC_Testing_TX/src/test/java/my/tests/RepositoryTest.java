package my.tests;

import my.dal.Product;
import my.dal.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-config.xml")
public class RepositoryTest {

    @Autowired
    Repository repository;

    @Test
    public void getProductsTest(){
        List<Product> products = repository.getProducts();
        Assertions.assertEquals(504, products.size());
    }
}
