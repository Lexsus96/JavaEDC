package part1.lesson03;

import part1.lesson01.task03.Person;
import part1.lesson01.task03.Sex;

public class Solution {
    private final static CardFilePet CARD_FILE_PET = new CardFilePet(){{
        try {
            addPet(new Pet(1, "Chappi", new Person("Volodya", 10, Sex.MAN), 10));
            addPet(new Pet(2, "Bhappi", new Person("Volodya", 10, Sex.WOMAN), 2));
            addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13));
        } catch (DuplicatePetException e) {
            e.printStackTrace();
        }
    }};
    public static void main(String[] args){
        System.out.println("sortPetsByWeight: " + CARD_FILE_PET.sortPetsByWeight());
        System.out.println("sortPetsByName: " + CARD_FILE_PET.sortPetsByName());
        System.out.println("sortPetsByPerson: " + CARD_FILE_PET.sortPetsByPerson());

        System.out.println("findPet(Chappi): " + CARD_FILE_PET.findFirstPetByName("Chappi"));
        CARD_FILE_PET.editPet(1, "Champ");
        System.out.println("New name: " + CARD_FILE_PET.getMap().get(1).getName());

        try {
            CARD_FILE_PET.addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13));
        } catch (DuplicatePetException e) {
            System.out.println(e.getMessage());
        }

    }
}
