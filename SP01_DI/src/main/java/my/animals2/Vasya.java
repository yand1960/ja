package my.animals2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vasya")
public class Vasya implements Human {
    private String name = "Vasya";

    @Autowired
    @Qualifier("bobik")
    private Animal pet;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public Animal getPet() {
        return pet;
    }

    @Override
    //@Autowired
    public void setPet(Animal animal) {
        pet = animal;
    }

    @Override
    public void feed() {
        pet.eat();
        System.out.println(pet.getVoice());
    }

    @Override
    public void tease() {
        System.out.println("I am angry " + pet.getVoice());
    }
}
