package my.rest;

import my.buslog.ProductFilter;
import my.dal.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
public class ProductController {

    @Autowired
    ProductFilter filter;

    @RequestMapping("api/time")
    public String time() {
        return (new Date()).toString();
    }


    @RequestMapping("api/products")
    public List<Product> products(String letters) {
        return
            filter.filterByFirstLetters(letters);
    }

}
