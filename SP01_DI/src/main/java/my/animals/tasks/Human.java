package my.animals.tasks;

public interface Human {
    String getName();
    void setName(String value);
    Animal getPet();
    void setPet(Animal animal);
    void feed();
    void tease();
}
