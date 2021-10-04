package my.animals.tasks;

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

    @Override
    public void escape() {

    }

    @Override
    public Class getEnemy() {
        return null;
    }

    @Override
    public void setEnemy(Class enemy) {

    }
}
