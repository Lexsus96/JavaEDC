import org.junit.jupiter.api.*;
import part1.lesson02.MathBox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class Lesson02Test {
    MathBox<Integer> mathBoxInteger = new MathBox<>(new Integer[]{1, 2, 3});
    
    @BeforeAll
    static void setup() {
        System.out.println("[START: Lesson02]");
    }

    @AfterAll
    static void finale() {
        System.out.println("[END: Lesson02]");
    }

    @Test
    @DisplayName("TestDump")
    void testDump() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream defaultStream = System.out;
        System.setOut(new PrintStream(outContent));
        mathBoxInteger.dump();
        System.setOut(defaultStream);
        Assertions.assertEquals("[1, 2, 3]", outContent.toString());
    }

    @Test
    @DisplayName("TestDelete")
    void testDelete() {
        MathBox<Integer> mathBox = new MathBox<>(new Integer[]{1, 2, 3});
        mathBox.deleteObject(2);
        mathBox.deleteObject(3);
        Assertions.assertEquals("[1]", mathBox.getList().toString());
    }

    @Test
    @DisplayName("TestAdd")
    void testAdd() {
        MathBox<Integer> mathBox = new MathBox<>(new Integer[]{1});
        mathBox.addObject(2);
        mathBox.addObject(3);
        Assertions.assertEquals("[1, 2, 3]", mathBox.getList().toString());
    }

    @Test
    @DisplayName("TestSummator")
    void testSummator() {
        Assertions.assertEquals("6", mathBoxInteger.summator().toString());
    }
    @Test
    @DisplayName("TestSplitter")
    void testSplitter() {
        MathBox<Double> mathBoxDouble = new MathBox<>(new Double[]{1.0, 2.0, 3.0});
        mathBoxDouble.splitter(2.0);
        Assertions.assertEquals("[0.5, 1.0, 1.5]", mathBoxDouble.getList().toString());
    }

}
