package part1.lesson03;


import part1.lesson01.task03.Person;

import java.util.Objects;

public class Pet implements Comparable<Pet>{
    private int UUID;
    private String name;
    private Person person;
    private double weight;
    private PetType petType;

    public Pet(int UUID, String name, Person person, double weight, PetType petType) {
        this.UUID = UUID;
        this.name = name;
        this.person = person;
        this.weight = weight;
        this.petType = petType;
    }
    public Pet(Pet pet) {
        this.UUID = pet.UUID;
        this.name = pet.name;
        this.person = new Person(pet.person.getName(), pet.person.getAge(), pet.person.getSex());
        this.weight = pet.weight;
        this.petType = pet.petType;
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

    public int getUUID() {
        return UUID;
    }

    public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
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
        return String.format("{UID: %s; Name: %s; Person: {%s}; Weight: %f; Type: %s}", UUID, name, person, weight, petType);
    }

    @Override
    public int compareTo(Pet pet) {
        if (this.petType == pet.petType) {
            if (this.name.equals(pet.name)) {
                return Double.compare(this.weight, pet.weight);
            } else {
                return this.name.compareTo(pet.name);
            }
        } else {
            if (this.petType == PetType.Cat || this.petType == PetType.Dog && pet.petType == PetType.Bear) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
