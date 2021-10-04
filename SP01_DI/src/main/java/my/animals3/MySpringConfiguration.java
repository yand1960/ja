package my.animals3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySpringConfiguration {

    Animal bobik, sharik, cat;

    BusinessProcess process;
    Human person;

    public MySpringConfiguration() {
        person = new Vasya();
        person.setName("Vasilij");
        process = new FeedProcess(person);
    }

    @Bean
    public Animal cat() {
        cat = new Cat();
        return cat;
    }

    @Bean
    public Animal bobik() {
        bobik = new Dog();
        bobik.setVoice("RRRRR Gav");
        return bobik;
    }

    @Bean
    public Animal sharik() {
        sharik = new Dog();
        sharik.setVoice("Gav gav");
        return sharik;
    }

    @Bean
    public Human person() {
        person.setPet(cat);
        return person;
    }

    @Bean
    public BusinessProcess process() {
        return process;
    }

}
