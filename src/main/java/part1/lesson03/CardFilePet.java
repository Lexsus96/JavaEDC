package part1.lesson03;

import part1.lesson01.task03.Person;
import part1.lesson01.task03.Sex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardFilePet {
    private Map<Integer, Pet> map = new HashMap<>();
    private Map<String, List<Pet>> nameMap = new HashMap<>();
    private Set<Pet> set = new TreeSet<>();

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
        if (map.containsKey(pet.getUUID())) {
            throw new DuplicatePetException(pet + " already exists!");
        }
        map.put(pet.getUUID(), pet);
        set.add(pet);
        addPetToNameMap(pet);
    }
    private void addPetToNameMap(Pet pet) {
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
        List<Pet> nameList = nameMap.get(pet.getName());
        nameList.remove(pet);
        pet.setName(name);
        set.add(pet);
        addPetToNameMap(pet);
    }

    public void editPet(int uid, int weight) {
        Pet pet = map.get(uid);
        pet.setWeight(weight);
        set.add(pet);
    }
    public void editPet(int uid, Person person) {
        Pet pet = map.get(uid);
        pet.setPerson(person);
        set.add(pet);
    }
    public Pet findFirstPetByName(String name) {
        return nameMap.get(name).stream().findAny().orElse(null);
    }
    public List<Pet> sort(Comparator<Pet> comparator) {
        List<Pet> list = new ArrayList<>(map.values());
        list.sort(comparator);
        return list;
    }
    public List<Pet> getSortedList() {
        return new ArrayList<>(set);
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

    public double getAverageAgeOfPerson() {
        return map.values().stream().map(Pet::getPerson).distinct().mapToInt(Person::getAge).average().orElse(-1);
    }
    public List<Person> getPersonListOfType(Sex sex){
        return map.values().stream().map(Pet::getPerson).distinct().filter(person -> person.getSex().equals(sex)).collect(Collectors.toList());
    }
    public long countPetOfType(PetType petType){
        return map.values().stream().filter(pet -> pet.getPetType() == petType).count();
    }
}
