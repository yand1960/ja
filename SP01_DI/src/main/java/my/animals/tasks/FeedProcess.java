package my.animals.tasks;

public class FeedProcess implements BusinessProcess {

    Human person;

    public FeedProcess(Human person) {
        this.person = person;
    }

    @Override
    public void start() {
        System.out.println(person.getName() + " feeds his pet");
        person.feed();
    }
}
