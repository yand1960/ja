package my.animals2;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.annotation.Repeatable;

// Помиомо @Component есть еще:
// @Service, @Repository, @Controller
// Детали https://stackoverflow.com/questions/6827752/whats-the-difference-between-component-repository-service-annotations-in
@Component("trigger")
public class FeedProcess implements BusinessProcess {

    Human person;

    //При аннотационном конфигурировании возможна
    // инжекция через конструктор
    public FeedProcess(Human person) {
        this.person = person;
    }

    @Override
    public void start() {
        System.out.println(person.getName() + " feeds his pet");
        person.feed();
    }
}
