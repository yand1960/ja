package my.animals.tasks;

import java.util.List;

public class Rendevouz implements BusinessProcess {

    List<Animal> animals;

    public Rendevouz(List<Animal> animals) {
        this.animals =animals;
    }

    @Override
    public void start() {
        for(Animal a1: animals) {
            for(Animal a2:animals) {
                if (a1.getEnemy() == a2.getClass())
                    a1.escape();
            }
        }
    }
}
