package part1.lesson03;

import part1.lesson01.task03.Person;

import java.util.*;
import java.util.function.Function;

public class CardFilePet {
    private Map<Integer, Pet> map = new HashMap<>();
    Map<String, List<Pet>> nameMap = new HashMap<>();
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

    public void addPet(Pet pet) {
        if (map.containsKey(pet.getUid())) {
            throw new DuplicatePetException(pet + " already exists!");
        }
        map.put(pet.getUid(), pet);
        if (nameMap.containsKey(pet.getName())) {
            nameMap.get(pet.getName()).add(pet);
        } else {
            List<Pet> list = new ArrayList<>();
            list.add(pet);
            nameMap.put(pet.getName(), list);
        }
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
        List<Pet> list = nameMap.getOrDefault(name, null);
        if (list == null) {
            return null;
        }
        Optional<Pet> optionalPet= list.stream().findAny();
        return optionalPet.orElse(null);
    }
    public List<Pet> sort(Comparator<Pet> comparator) {
        List<Pet> list = new ArrayList<>(map.values());
        list.sort(comparator);
        return list;
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

    public  Map<Integer, Pet> getMap() {
        return map;
    }
}
