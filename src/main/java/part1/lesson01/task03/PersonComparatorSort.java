package part1.lesson01.task03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonComparatorSort implements PersonSortable {
    @Override
    public List<Person> sortPersons(List<Person> list) {
        List<Person> sortedList = new ArrayList<>(list);
        sortedList.sort(Person::compareTo);
        return sortedList;
    }
}
