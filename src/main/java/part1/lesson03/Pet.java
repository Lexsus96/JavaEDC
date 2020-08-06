package part1.lesson03;


import part1.lesson01.task03.Person;

import java.util.Objects;

public class Pet {
    private int UUID;
    private String name;
    private Person person;
    private double weight;

    public Pet(int UUID, String name, Person person, double weight) {
        this.UUID = UUID;
        this.name = name;
        this.person = person;
        this.weight = weight;
    }
    public Pet(Pet pet) {
        this.UUID = pet.UUID;
        this.name = pet.name;
        this.person = new Person(pet.person.getName(), pet.person.getAge(), pet.person.getSex());
        this.weight = pet.weight;
    }
    public int getUid() {
        return UUID;
    }

    public void setUid(int uid) {
        this.UUID = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return UUID == pet.UUID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(UUID);
    }

    @Override
    public String toString() {
        return String.format("{UID: %s; Name: %s; Person: {%s}; Weight: %f}", UUID, name, person, weight);
    }
}
