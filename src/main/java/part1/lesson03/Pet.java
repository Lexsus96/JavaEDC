package part1.lesson03;


import part1.lesson01.task03.Person;

import java.util.Objects;

public class Pet {
    private int uid;
    private String name;
    private Person person;
    private int weight;

    public Pet(int uid, String name, Person person, int weight) {
        this.uid = uid;
        this.name = name;
        this.person = person;
        this.weight = weight;
    }
    public Pet(Pet pet) {
        this.uid = pet.uid;
        this.name = pet.name;
        this.person = new Person(pet.person.getName(), pet.person.getAge(), pet.person.getSex());
        this.weight = pet.weight;
    }
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return uid == pet.uid &&
                weight == pet.weight &&
                Objects.equals(name, pet.name) &&
                Objects.equals(person, pet.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, name, person, weight);
    }

    @Override
    public String toString() {
        return String.format("{UID: %s; Name: %s; Person: {%s}; Weight: %d}", uid, name, person, weight);
    }
}
