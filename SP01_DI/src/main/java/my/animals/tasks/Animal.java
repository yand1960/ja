package my.animals.tasks;

public interface Animal {
    void eat();
    String getVoice();
    void setVoice(String value);
    void escape();
    Class getEnemy();
    void setEnemy(Class enemy);
}
