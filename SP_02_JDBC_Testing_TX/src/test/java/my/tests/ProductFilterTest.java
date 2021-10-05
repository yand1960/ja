package my.tests;

import my.buslog.ProductFilter;
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
public class ProductFilterTest {

    @Autowired
    ProductFilter filter;

    @Test
    public void getFilterByFirstLettersTest(){
        List<Product> products = filter.filterByFirstLetters("a");
        Assertions.assertEquals(3, products.size());
    }
}
