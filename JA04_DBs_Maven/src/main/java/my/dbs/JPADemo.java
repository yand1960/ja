package my.dbs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

// Файл persistence.xml должен находиться на classpath'е
// в папке META-INF. Т.е. в мавеновском проекте он
// должен быть в папке src/main/Resources/META-INF.

public class JPADemo {
    public static void main(String[] args) {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("aw_jpa_unit");
        EntityManager em = factory.createEntityManager();

        List<Product> products =
                em.createQuery("SELECT p FROM Product p WHERE p.price > 1000")
                        .getResultList();
        products.forEach(p -> {
            System.out.println(p.getName() + " " + p.getPrice());
        });
    }
}
