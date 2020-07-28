package part1.lesson01.task03;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) throws IllegalArgumentException {
        this.name = name;
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Неверный возраст");
        }
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public int compareTo(Person o) {
        if (sex == o.getSex()) {
            if (age == o.getAge()) {
                String s2 = o.getName();
                if (name.length() != s2.length()) {
                    return name.length() - s2.length();
                }
                return name.compareTo(s2);
            } else {
                return o.getAge() - age;
            }
        } else if (sex == Sex.MAN) {
            return -1;
        } else {
            return 1;
        }
    }
}
