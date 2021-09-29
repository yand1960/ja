package my.dal.tests;

import my.dal.Repository;
import my.dal.RepositoryJDBC;
import org.junit.jupiter.api.Test;

public class RepositoryTests {

    @Test
    public void testGetAllProducts() {
        Repository repository = new RepositoryJDBC();
        System.out.println(
                repository.getAllProducts().get(0).getName()
        );

    }
}
