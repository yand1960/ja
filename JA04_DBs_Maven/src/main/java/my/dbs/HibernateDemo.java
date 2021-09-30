package my.dbs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                                        .configure()
                                        .buildSessionFactory();
        Session session = factory.openSession();

        String filter = "b";
        String hql = "SELECT p FROM Product p WHERE p.name LIKE :p1 ";
        List<Product> products = session.createQuery(hql)
                                        .setParameter("p1", filter + "%")
                                        .list();

        products.forEach(p -> {
            System.out.println(p.getName() + " " + p.getPrice());
        });

//        Product p = products.get(0);
//        p.setPrice(123.45);
//        session.beginTransaction();
//        //session.save(p);
//        session.getTransaction().commit(); //ошибка прав но SQL хороший

        Product p = session.get(Product.class, 1);
        p.setPrice(123.45);
        session.beginTransaction().commit();

//          Product p = new Product();
//          p.setName("lala");
//          p.setCode("12345");
//          p.setPrice(123.4);
//          session.beginTransaction();
//          session.save(p);
//          session.getTransaction().commit(); //ошибка прав но SQL хороший
    }
//        Напишите Hibernate код, который добавит в таблицу Hackers
//        ваше имя и выведет все имена, которые там есть.
//        Таблица расположена в базе данных SB того же сервера.

}
