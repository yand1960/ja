package my.tests;

import com.sun.org.apache.regexp.internal.RE;
import my.buslog.ProductFilter;
import my.dal.Repository;
import my.dal.RepositoryStub;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestSpringConfiguration {

    Repository repository;
    ProductFilter filter;

    public TestSpringConfiguration() {
        repository = new RepositoryStub();
        filter = new ProductFilter(repository);
    }

    @Bean
    public Repository repository() {
        return repository;
    }

    @Bean
    public ProductFilter filter() {
        return filter;
    }


}
