package my.animals.tasks;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        // При POJO не удается избежать тесных зависимостей
//        Animal a1 = new Cat();
//        a1.eat();

        // Революция! Полностью loosely coupled code
        Animal a1;
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config-task1.xml");
//        a1 = context.getBean("pet1",Animal.class);
//        a1.eat();
//        System.out.println(a1.getVoice());

        //Бизнес - процесс обычно реализуется и запускается внутри боба
        // Поэтому данный внеконтекстный код не типичен
//        Human person = context.getBean(Human.class);
//        System.out.println(person.getName() + " feeds his pet");
//        person.feed();

        // А это типично: собрать контекст и запустить в нем процесс
        context.getBean(BusinessProcess.class).start();

//        Напишите бизнес процесс, в котором оба животных из контекста
//        покормятся самостоятельно. Процесс назовем SelfFeedingProcess
    }
}
