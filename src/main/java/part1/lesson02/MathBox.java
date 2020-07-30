package part1.lesson02;

import part1.lesson02.Calculators.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<T>{
    Calculator<T> calculator;

    Map<Class<?>, Calculator<?>> map = new HashMap<>(){{
        put(Integer.class, new IntegerCalculator());
        put(Double.class, new DoubleCalculator());
        put(Float.class, new FloatCalculator());
        put(Long.class, new LongCalculator());
        put(Short.class, new ShortCalculator());
        put(Byte.class, new ByteCalculator());
    }};

    public MathBox(T[] arr) {
        if (arr.length != 0) {
            Class<T> clazz = (Class<T>) arr[0].getClass();
            if (map.containsKey(clazz)) {
                calculator = (Calculator<T>) map.get(clazz);
            }
        }
        for (T item : arr) {
            addObject(item);
        }
    }

    public MathBox(T[] arr, Calculator<T> calculator) {
        this.calculator = calculator;
        for (T item : arr) {
            addObject(item);
        }
    }

    public T summator() {
        return getList().stream().reduce(calculator.zero(), calculator::add);
    }

    public void splitter(T item) {
        List<T> list = getList();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, calculator.divide(list.get(i), item));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(getList(), mathBox.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList());
    }

    @Override
    public String toString() {
        return getList().toString();
    }
}
