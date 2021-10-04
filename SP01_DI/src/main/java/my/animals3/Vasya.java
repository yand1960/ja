package my.animals3;

public class Vasya implements Human {
    private String name = "Vasya";
    private Animal pet;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public Animal getPet() {
        return pet;
    }

    @Override
    public void setPet(Animal animal) {
        pet = animal;
    }

    @Override
    public void feed() {
        pet.eat();
        System.out.println(pet.getVoice());
    }

    @Override
    public void tease() {
        System.out.println("I am angry " + pet.getVoice());
    }
}
