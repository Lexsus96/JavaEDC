package part1.lesson01.task03;

import java.util.List;

public class PersonInsertionSort implements PersonSortable {
    @Override
    public void sortPersons(List<Person> list) {
        for (int i = 1; i < list.size(); i++) {
            Person current = list.get(i);
            int j = i - 1;
            while(j >= 0 && compare(list.get(j), current)) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }
    private boolean compare (Person o1, Person o2) {
        if (o1.getSex().getS().equals(o2.getSex().getS())) {
            if (o1.getAge() == o2.getAge()) {
                String s1 = o1.getName();
                String s2 = o2.getName();
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length() > 0;
                }
                return s1.compareTo(s2) > 0;
            } else {
                return o2.getAge() - o1.getAge() > 0;
            }
        } else return !o1.getSex().getS().equals(Sex.MAN);
    }
}
