package part1.lesson01.task03;

import java.util.ArrayList;
import java.util.List;

public class PersonInsertionSort implements PersonSortable {
    @Override
    public List<Person> sortPersons(List<Person> list) {
        List<Person> sortedList = new ArrayList<>(list);
        for (int i = 1; i < sortedList.size(); i++) {
            Person current = sortedList.get(i);
            int j = i - 1;
            while(j >= 0 && sortedList.get(j).compareTo(current) > 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, current);
        }
        return sortedList;
    }
}
