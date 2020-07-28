import org.junit.jupiter.api.*;
import part1.lesson01.task01.HelloWorld;
import part1.lesson01.task01.Solution;
import part1.lesson01.task02.NRandoms;
import part1.lesson01.task02.NegativeException;
import part1.lesson01.task03.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Lesson01Test {
    @BeforeAll
    static void setup() {
        System.out.println("[START]");
    }

    @AfterAll
    static void finale() {
        System.out.println("[END]");
    }

    @Test
    @DisplayName("Task01NullPointerException")
    void testThrowNullPointerException() {
        Throwable exception = assertThrows(NullPointerException.class, HelloWorld::throwNullPointerException);
        assertEquals("NullPointerException", exception.getClass().getSimpleName() );
    }

    @DisplayName("Task01ArrayIndexOutOfBoundsException")
    @Test
    public void testThrowArrayIndexOutOfBoundsException() {
        Throwable exception = assertThrows(ArrayIndexOutOfBoundsException.class, HelloWorld::throwArrayIndexOutOfBoundsException);
        assertEquals("ArrayIndexOutOfBoundsException", exception.getClass().getSimpleName() );
    }

    @DisplayName("Task01ThrowIOException")
    @Test
    public void testThrowIOException() {
        Throwable exception = assertThrows(IOException.class, HelloWorld::throwIOException);
        assertEquals("IOException", exception.getClass().getSimpleName());
    }

    @DisplayName("Task02NegativeException")
    @Test
    public void testThrowNegativeException()  {
        try {
            NRandoms nRandoms = new NRandoms(1);
            Field field = nRandoms.getClass().getDeclaredField("list");
            field.setAccessible(true);
            List<Integer> list = new ArrayList<>(1);
            list.add(-1);
            field.set(nRandoms, list);
            Throwable exception = assertThrows(NegativeException.class, nRandoms::printSquares);
            assertEquals("NegativeException", exception.getClass().getSimpleName());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            assertEquals("NegativeException", e.getClass().getSimpleName());
        }
    }
    @DisplayName("Task02PrintSquares")
    @Test
    public void testPrintSquares()  {
        try {
            NRandoms nRandoms = new NRandoms(1);
            Field field = nRandoms.getClass().getDeclaredField("list");
            field.setAccessible(true);
            List<Integer> list = new ArrayList<>(3);
            for (int i = 1; i < 4; i++) {
                list.add(i * i);
            }
            list.add(7);
            field.set(nRandoms, list);

            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            PrintStream defaultStream = System.out;
            System.setOut(new PrintStream(outContent));

            nRandoms.printSquares();

            assertEquals("1 4 9 ", outContent.toString());

            System.setOut(defaultStream);
        } catch (NoSuchFieldException | IllegalAccessException | NegativeException e) {
            assertEquals("1 4 9 ", e.getClass().getSimpleName());
        }
    }

    @DisplayName("Task03PersonComparatorSort")
    @Test
    public void testPersonComparatorSort() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Person1", 10, Sex.WOMAN));
        list.add(new Person("Person1", 10, Sex.MAN));
        list.add(new Person("Person2", 10, Sex.MAN));
        list.add(new Person("Person2", 100, Sex.MAN));
        list.add(new Person("Person1", 100, Sex.WOMAN));

        PersonSortable personSortable = new PersonComparatorSort();
        list = personSortable.sortPersons(list);

        List<Person> answer = new ArrayList<>();
        answer.add(new Person("Person2", 100, Sex.MAN));
        answer.add(new Person("Person1", 10, Sex.MAN));
        answer.add(new Person("Person2", 10, Sex.MAN));
        answer.add(new Person("Person1", 100, Sex.WOMAN));
        answer.add(new Person("Person1", 10, Sex.WOMAN));

        Assertions.assertEquals(answer, list);
    }

    @DisplayName("Task03PersonInsertionSort")
    @Test
    public void testPersonInsertionSort() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Person1", 10, Sex.WOMAN));
        list.add(new Person("Person1", 10, Sex.MAN));
        list.add(new Person("Person2", 10, Sex.MAN));
        list.add(new Person("Person2", 100, Sex.MAN));
        list.add(new Person("Person1", 100, Sex.WOMAN));

        PersonSortable personSortable = new PersonInsertionSort();
        list = personSortable.sortPersons(list);

        List<Person> answer = new ArrayList<>();
        answer.add(new Person("Person2", 100, Sex.MAN));
        answer.add(new Person("Person1", 10, Sex.MAN));
        answer.add(new Person("Person2", 10, Sex.MAN));
        answer.add(new Person("Person1", 100, Sex.WOMAN));
        answer.add(new Person("Person1", 10, Sex.WOMAN));

        Assertions.assertEquals(answer, list);
    }

    @DisplayName("Task03PersonInsertionSortNULL")
    @Test
    public void testPersonInsertionSortNULL() {
        PersonSortable personSortable = new PersonInsertionSort();
        List<Person> list = personSortable.sortPersons(null);
        Assertions.assertNull(list);
    }

    @DisplayName("Task03PersonComparatorSortNULL")
    @Test
    public void testPersonComparatorSortNULL() {
        PersonSortable personSortable = new PersonComparatorSort();
        List<Person> list = personSortable.sortPersons(null);
        Assertions.assertNull(list);
    }
}
