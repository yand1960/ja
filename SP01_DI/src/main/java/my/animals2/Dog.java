package my.animals2;

import org.springframework.stereotype.Component;

@Component("bobik")
public class Dog implements Animal {
    private String voice = "Hab";

    @Override
    public void eat() {
        System.out.println("I eat bones");
    }

    @Override
    public String getVoice() {
        return voice;
    }

    @Override
    public void setVoice(String value) {
        voice = value;
    }
}
