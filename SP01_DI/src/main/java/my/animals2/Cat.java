package my.animals2;

import org.springframework.stereotype.Component;

@Component("pet1")
public class Cat implements Animal {
    private String voice = "Meow";
    @Override
    public void eat() {
        System.out.println("I eat mice");
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
