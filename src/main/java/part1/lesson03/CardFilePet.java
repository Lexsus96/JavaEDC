package part1.lesson03;

import part1.lesson01.task03.Person;

import java.util.*;

public class CardFilePet implements Cloneable{
    SortedMap<Integer, Pet> map = new TreeMap<>();

    public CardFilePet() {

    }
    public CardFilePet (CardFilePet cardFilePet) {
        for (Pet pet: cardFilePet.map.values()) {
            try {
                this.addPet(new Pet(pet));
            } catch (DuplicatePetException e) {
                e.printStackTrace();
            }
        }
    }
    public Pet getPet(int id) {
        return map.get(id);
    }
    public void addPet(Pet pet) throws DuplicatePetException{
        if (map.containsKey(pet.getUid())) {
            throw new DuplicatePetException(pet + " already exists!");
        }
        map.put(pet.getUid(), pet);
    }
    public void editPet(int uid, String name) {
        Pet pet = map.get(uid);
        pet.setName(name);
    }

    public void editPet(int uid, int weight) {
        Pet pet = map.get(uid);
        pet.setWeight(weight);

    }
    public void editPet(int uid, Person person) {
        Pet pet = map.get(uid);
        pet.setPerson(person);
    }
    public Pet findFirstPetByName(String name) {
        if (name == null) {
            return null;
        }
        for(Pet pet: map.values()) {
            if (name.equals(pet.getName())) {
                return pet;
            }
        }
        return null;
    }

    public List<Pet> sortPetsByPerson() {
        List<Pet> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(Pet::getPerson));
        return list;
    }

    public List<Pet> sortPetsByName() {
        List<Pet> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(Pet::getName));
        return list;
    }
    public List<Pet> sortPetsByWeight() {
        List<Pet> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparing(Pet::getWeight));
        return list;
    }

}
