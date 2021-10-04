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

// 1. Установите jdk1.8 и Tomcat 9.0 - на новые дни.
// 2. Добавьте животным атрибут Enemy.
// Это указатель на класс (Class), который
// для данного животного является врагом.
// Еще у животного добавьте метод escape() (удрать).
// Реализуйте  бизнес процесс Rendevouz:
// животные встречаются, "осматриваются",
// и тот, кто обнаруживает врога, удирает.
