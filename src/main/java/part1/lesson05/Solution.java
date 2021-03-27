package part1.lesson05;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Solution {

    private static final String input = "src/main/resources/lesson05/input.txt";
    private static final String output = "src/main/resources/lesson05/output.txt";
    private static final String directory = "src/main/resources/lesson05";

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        String[] words = fileProcessor.generateWords(25);
        try {
            /*Task01*/
            fileProcessor.readWordsFromFile(Paths.get(input));
            fileProcessor.writeWordsToFile(Paths.get(output));
            /*Task02*/
            fileProcessor.getFiles(directory, 5, 1000, words);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
