package my.animals2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {

        Animal a1;
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config2.xml");
        //context.getBean(BusinessProcess.class).start();
        context.getBean(SelfFeedingProcess.class).start();

    }
}
