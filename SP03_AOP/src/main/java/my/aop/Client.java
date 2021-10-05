package my.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");

        Calc calc = context.getBean(Calc.class);
        System.out.println(calc.plus(1,2));
        System.out.println(calc.minus(1,2));

        System.out.println(calc.getClass().toString());

    }
}
