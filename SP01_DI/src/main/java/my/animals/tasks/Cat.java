package my.animals.tasks;

public class Cat implements Animal {
    private String voice = "Meow";
    private Class enemy = Dog.class;

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

    @Override
    public void escape() {
        System.out.println("Лезу на дерево");
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
