package my.animals.tasks;

public class Dog implements Animal {
    private String voice = "Hab";
    private Class enemy;

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
        System.out.println("Прячусь в будке");
    }

    @Override
    public Class getEnemy() {
        return enemy;
    }

    @Override
    public void setEnemy(Class enemy) {
        this.enemy = enemy;
    }
}
