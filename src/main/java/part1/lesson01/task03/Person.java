package part1.lesson01.task03;

public class Person {
    private String name;
    private int age;
    private Sex sex; // странное условие, я бы сделал enum или boolean

    // age: -> [0;100]
    // sex: true - MAN; false - WOMAN
    public Person(String name, int age, boolean sex) throws IllegalArgumentException {
        this.name = name;
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Неверный возраст");
        }
        this.age = age;
        this.sex = new Sex(sex);
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
        return name + " " + age + " " + sex.getS();
    }
}
