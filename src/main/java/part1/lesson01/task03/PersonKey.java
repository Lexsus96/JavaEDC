package part1.lesson01.task03;

import java.util.Objects;

public class PersonKey {
    int age;
    String name;
    public PersonKey(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonKey)) return false;
        PersonKey personKey = (PersonKey) o;
        return age == personKey.age &&
                Objects.equals(name, personKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
