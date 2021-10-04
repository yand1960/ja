package my.animals.tasks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {

        Animal a1;
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-task1.xml");

        context.getBean(BusinessProcess.class).start();

    }
}
