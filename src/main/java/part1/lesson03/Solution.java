package part1.lesson03;

import part1.lesson01.task03.Person;
import part1.lesson01.task03.Sex;

public class Solution {
    static CardFilePet cardFilePet = new CardFilePet(){{
        try {
            addPet(new Pet(1, "Chappi", new Person("Volodya", 10, Sex.MAN), 10));
            addPet(new Pet(2, "Bhappi", new Person("Volodya", 10, Sex.WOMAN), 2));
            addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13));
        } catch (DuplicatePetException e) {
            e.printStackTrace();
        }
    }};
    public static void main(String[] args){
        System.out.println("sortPetsByWeight: " + cardFilePet.sortPetsByWeight());
        System.out.println("sortPetsByName: " + cardFilePet.sortPetsByName());
        System.out.println("sortPetsByPerson: " + cardFilePet.sortPetsByPerson());

        System.out.println("findPet(Chappi): " + cardFilePet.findFirstPetByName("Chappi"));
        cardFilePet.editPet(1, "Champ");
        System.out.println("New name: " + cardFilePet.map.get(1).getName());

        try {
            cardFilePet.addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13));
        } catch (DuplicatePetException e) {
            System.out.println(e.getMessage());
        }

    }
}
