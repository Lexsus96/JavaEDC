import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import part1.lesson01.task01.HelloWorld;
import part1.lesson01.task03.Person;
import part1.lesson01.task03.Sex;
import part1.lesson03.CardFilePet;
import part1.lesson03.DuplicatePetException;
import part1.lesson03.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Lesson03Test {
    private static final CardFilePet cardFilePet = new CardFilePet(){{
        try {
            addPet(new Pet(1, "Chappi", new Person("Volodya", 10, Sex.MAN), 10.0));
            addPet(new Pet(2, "Bhappi", new Person("Volodya", 10, Sex.WOMAN), 2.0));
            addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13.0));
        } catch (DuplicatePetException e) {
            e.printStackTrace();
        }
    }};

    private final static String sortedPetsByWeight = "[{UID: 2; Name: Bhappi; Person: {Volodya 10 WOMAN}; Weight: 2,000000}, {UID: 1; Name: Chappi; Person: {Volodya 10 MAN}; Weight: 10,000000}, {UID: 3; Name: Ahappi; Person: {Aolody 10 WOMAN}; Weight: 13,000000}]";
    private final static String sortedPetsByName = "[{UID: 3; Name: Ahappi; Person: {Aolody 10 WOMAN}; Weight: 13,000000}, {UID: 2; Name: Bhappi; Person: {Volodya 10 WOMAN}; Weight: 2,000000}, {UID: 1; Name: Chappi; Person: {Volodya 10 MAN}; Weight: 10,000000}]";
    private final static String sortedPetsByPerson = "[{UID: 1; Name: Chappi; Person: {Volodya 10 MAN}; Weight: 10,000000}, {UID: 3; Name: Ahappi; Person: {Aolody 10 WOMAN}; Weight: 13,000000}, {UID: 2; Name: Bhappi; Person: {Volodya 10 WOMAN}; Weight: 2,000000}]";
    private final static String findFirstPetByName = "{UID: 1; Name: Chappi; Person: {Volodya 10 MAN}; Weight: 10,000000}";
    private final static String editedPet = "{UID: 1; Name: Chappi2; Person: {Volodya 10 WOMAN}; Weight: 15,000000}";
    private final static String addPet = "[{UID: 4; Name: 1; Person: {1 1 MAN}; Weight: 1,000000}, {UID: 2; Name: Bhappi; Person: {Volodya 10 WOMAN}; Weight: 2,000000}, {UID: 1; Name: Chappi; Person: {Volodya 10 MAN}; Weight: 10,000000}, {UID: 3; Name: Ahappi; Person: {Aolody 10 WOMAN}; Weight: 13,000000}]";
    private final static String name = "Chappi";

    @BeforeAll
    static void setup() {
        System.out.println("[START: Lesson03]");
    }

    @AfterAll
    static void finale() {
        System.out.println("[END: Lesson03]");
    }

    @Test
    @DisplayName("TestThrowDuplicatePetException")
    void testThrowNullPointerException() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        boolean duplicate = false;
        try {
            tmp.addPet(new Pet(3, "Ahappi", new Person("Aolody", 10, Sex.WOMAN), 13.0));
        } catch (DuplicatePetException e) {
            duplicate = true;
            assertEquals("DuplicatePetException", e.getClass().getSimpleName() );
        }
        assert duplicate;
    }

    @Test
    @DisplayName("TestSortPetsByWeight")
    void testSortPetsByWeight() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(sortedPetsByWeight, tmp.sortPetsByWeight().toString());
    }

    @Test
    @DisplayName("TestSortPetsByName")
    void testSortPetsByName() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(sortedPetsByName, tmp.sortPetsByName().toString());
    }

    @Test
    @DisplayName("TestSortPetsByPerson")
    void testSortPetsByPerson() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(sortedPetsByPerson, tmp.sortPetsByPerson().toString());
    }

    @Test
    @DisplayName("TestFindFirstPetByName")
    void testFindFirstPetByName() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        assertEquals(findFirstPetByName, tmp.findFirstPetByName(name).toString());
    }

    @Test
    @DisplayName("TestEditPetById")
    void testEditPetById() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        tmp.editPet(1, "Chappi2");
        tmp.editPet(1, 15);
        tmp.editPet(1, tmp.getPet(2).getPerson());
        assertEquals(editedPet, tmp.getPet(1).toString());
    }

    @Test
    @DisplayName("TestAddPet")
    void testAddPet() {
        CardFilePet tmp = new CardFilePet(cardFilePet);
        try {
            tmp.addPet(new Pet(4, "1", new Person("1", 1, Sex.MAN), 1));
        } catch (DuplicatePetException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(addPet, tmp.sortPetsByWeight().toString());
    }



}
