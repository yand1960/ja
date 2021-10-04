package my.animals.tasks;

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
