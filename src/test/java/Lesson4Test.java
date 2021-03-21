import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import part1.lesson01.task03.Person;
import part1.lesson01.task03.Sex;
import part1.lesson03.CardFilePet;
import part1.lesson03.DuplicatePetException;
import part1.lesson03.Pet;
import part1.lesson03.PetType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson4Test {
    private static final CardFilePet cardFilePet = new CardFilePet(){{
        try {
            addPet(new Pet(1, "Chappi", new Person("Volodya", 10, Sex.MAN), 10.0, PetType.Dog));
            addPet(new Pet(2, "Bhappi", new Person("Lilia", 21, Sex.WOMAN), 2.0, PetType.Bear));
            addPet(new Pet(3, "Ahappi", new Person("Katya", 29, Sex.WOMAN), 13.0, PetType.Bear));
        } catch (DuplicatePetException e) {
            e.printStackTrace();
        }
    }};
    private final static double AverageAgeOfPerson = 20.0;
    private final static String PersonListOfType = "[Lilia 21 WOMAN, Katya 29 WOMAN]";
    private final static long CountPetOfType = 2;

    @BeforeAll
    static void setup() {
        System.out.println("[START: Lesson04]");
    }

    @AfterAll
    static void finale() {
        System.out.println("[END: Lesson04]");
    }

    @Test
    @DisplayName("TestGetAverageAgeOfPerson")
    void testSortPetsByWeight() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(AverageAgeOfPerson, tmp.getAverageAgeOfPerson());
    }

    @Test
    @DisplayName("TestGetPersonListOfType")
    void testSortPetsByName() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(PersonListOfType, tmp.getPersonListOfType(Sex.WOMAN).toString());
    }

    @Test
    @DisplayName("TestCountPetOfType")
    void testSortPetsByPerson() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(CountPetOfType, tmp.countPetOfType(PetType.Bear));
    }
    
}
