package part1.lesson05;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {
    private TreeSet<String> words;
    private final int MAX_NUMBER = 15;
    private Random gen;

    public FileProcessor() {
        words = new TreeSet<>();
        gen = new Random();
    }

    public int readWordsFromFile(Path filePath) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        for (String s: lines) {
            s = s.replaceAll("[.,/#!$%^&*;:{}=\\-_`~()—]", " ");
            s = s.trim().replaceAll(" +", " ");
            List<String> list = Arrays.asList(s.split(" "));
            words.addAll(list.stream().map(String::toLowerCase).collect(Collectors.toList()));
        }
        return words.size();
    }

    public TreeSet<String> getWords() {
        return words;
    }

    public Path writeWordsToFile(Path filePath) throws IOException {
        return Files.write(filePath, words);
    }
    public void getFiles(String path, int n, int size, String[] words) throws IOException{
        for (int i = 0; i < n; i++) {
            String fileName = "/File";
            String newFileName = String.format("%s%s%d.txt", path, fileName, i);
            generateFile(Paths.get(newFileName), size, words);
        }
    }
    public void generateFile(Path path, int size, String[] words) throws IOException {
        OutputStream out = Files.newOutputStream(path);
            int sizeAbstract = getSizeOfAbstract();
        int AVG_SIZE_SENTENCE = 64;
        while (size - AVG_SIZE_SENTENCE / 2> 0) {
                String newS = generateSentence(words);
                out.write(newS.getBytes());
                sizeAbstract--;
                if (sizeAbstract == 0) {
                    sizeAbstract = getSizeOfAbstract();
                    out.write("\n\r".getBytes());
                    size = size - 2;
                }
                size = size - newS.length();
            }
        out.close();
    }
    public String generateSentence(String[] words) {
        String[] signs = {",", "", "", ""};
        String[] signsEnd = {". ", "! ", "? "};
        int sizeOfSentences = gen.nextInt(MAX_NUMBER) + 1;
        String newS = Stream.generate(() -> words[gen.nextInt(words.length)] + signs[gen.nextInt(4)]).limit(sizeOfSentences).collect(Collectors.joining(" "));
        if (newS.lastIndexOf(",") == newS.length() - 1) {
            newS = newS.substring(0, newS.length() - 1);
        }
        newS = firstUpperCase(newS) + signsEnd[gen.nextInt(3)];
        return newS;
    }

    public String[] generateWords(int size) {
        return Stream.generate(this::generateWord).limit(size).toArray(String[]::new);
    }

    public String generateWord() {
        int sizeOfWord = gen.nextInt(MAX_NUMBER) + 1;
        return Stream.generate( () -> ('a' + gen.nextInt(26))).limit(sizeOfWord).map(Character::toString).collect(Collectors.joining());
    }
    public String firstUpperCase(String word){
        if (word == null || word.isEmpty()) {
            return word;
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
    private int getSizeOfAbstract() {
        return gen.nextInt(20) + 1;
    }
}
