package my.animals3;

import java.util.List;

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
