package my.animals2;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("self_feeding")
public class SelfFeedingProcess implements BusinessProcess {

    List<Animal> animals;

    public SelfFeedingProcess(List<Animal> animals) {
        this.animals =animals;
    }

    @Override
    public void start() {
        for(Animal a: animals) {
            a.eat();
            System.out.println(a.getVoice());
        }
    }
}
