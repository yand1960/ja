package my.dal.tests;

import my.dal.Repository;
import my.dal.RepositoryJDBC;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTests {

    @Test
    public void testGetAllProducts() {
        Repository repository = new RepositoryJDBC();
        String result = repository.getAllProducts().get(0).getName();
        Assertions.assertEquals("Adjustable Race", result);
    }
}
