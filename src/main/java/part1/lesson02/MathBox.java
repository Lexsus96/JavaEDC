package part1.lesson02;

import part1.lesson02.Calculators.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<T>{
    Class<T> clazz;
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
            clazz = (Class<T>) arr[0].getClass();
        }
        for (T item : arr) {
            super.addObject(item);
        }
    }

    public T summator() {
        return sumValue((Calculator<T>) map.get(clazz));
    }

    public void splitter(T item) {
        divideList((Calculator<T>) map.get(clazz), (T) item);
    }

    public T sumValue(Calculator<T> calculator) {
        return getList().stream().reduce(calculator.zero(), calculator::add);
    }

    public void divideList(Calculator<T> calculator, T item) {
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
