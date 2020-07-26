package part1.lesson01.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static final int MAX_AGE = 100;

    public static List<Person> generateListOfPersons(int n) throws EqualPersonException, IllegalArgumentException{
        ArrayList<Person> list = new ArrayList<>(n);
        Set<PersonKey> set = new HashSet<>(n);
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < n; i++) {
            Person person = new Person("Person" + random.nextInt(n * MAX_AGE), random.nextInt(MAX_AGE) + 1, random.nextBoolean());
            PersonKey personKey = new PersonKey(person.getAge(), person.getName());
            if (set.contains(personKey)) {
                throw new EqualPersonException(person.toString() + " already exists!\n");
            } else {
                set.add(personKey);
            }
            list.add(person);
        }
        return list;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(bufferedReader.readLine());

            List<Person> list = generateListOfPersons(n);

            long startTime = new Date().getTime();
            PersonSortable personSortable = new PersonComparatorSort();
            personSortable.sortPersons(list);
            long comparatorTime = new Date().getTime() - startTime;

            list = generateListOfPersons(n);

            startTime = new Date().getTime();
            PersonSortable personInsertionSort = new PersonInsertionSort();
            personInsertionSort.sortPersons(list);
            long insertSortTime = new Date().getTime() - startTime;

            System.out.println("ComparatorSort: " + comparatorTime);
            System.out.println("InsertSort: " + insertSortTime);
        } catch (EqualPersonException | IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
