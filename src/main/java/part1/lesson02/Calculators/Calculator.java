package part1.lesson02.Calculators;

public interface Calculator<T extends Number> {
    T zero(); // Adding zero items
    T add(T o1, T o2); // Adding two items
    T divide(T o1, T o2);
}
