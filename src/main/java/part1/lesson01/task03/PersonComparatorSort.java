package part1.lesson01.task03;

import java.util.Comparator;
import java.util.List;

public class PersonComparatorSort implements PersonSortable {
    @Override
    public void sortPersons(List<Person> list) {
        Comparator<Person> comparatorPerson = (o1, o2) -> {
            if (o1.getSex().getS().equals(o2.getSex().getS())) {
                if (o1.getAge() == o2.getAge()) {
                    String s1 = o1.getName();
                    String s2 = o2.getName();
                    if (s1.length() != s2.length()) {
                        return s1.length() - s2.length();
                    }
                    return s1.compareTo(s2);
                } else {
                    return o2.getAge() - o1.getAge();
                }
            } else if (o1.getSex().getS().equals(Sex.MAN)) {
                return -1;
            } else {
                return 1;
            }
        };
        list.sort(comparatorPerson);
    }
}
