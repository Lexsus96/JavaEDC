package part1.lesson02;

import part1.lesson02.Calculators.*;

import java.util.List;
import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<T>{
    String clazz;
    public MathBox(T[] arr) {
        if (arr.length != 0) {
            clazz = arr[0].getClass().getSimpleName();
        }
        for (T item : arr) {
            super.addObject(item);
        }
    }
    public T summator() {
        switch (clazz) {
            case "Integer":
                CalcNumbers<Integer> i = new CalcNumbers<>();
                Integer si =  i.sumValue((List<Integer>) list, new IntegerCalculator());
                return (T) si;
            case "Double":
                CalcNumbers<Double> d = new CalcNumbers<>();
                Double sd =  d.sumValue((List<Double>) list, new DoubleCalculator());
                return (T) sd;
            case "Float":
                CalcNumbers<Float> f = new CalcNumbers<>();
                Float sf =  f.sumValue((List<Float>) list, new FloatCalculator());
                return (T) sf;
            case "Short":
                CalcNumbers<Short> s = new CalcNumbers<>();
                Short ss =  s.sumValue((List<Short>) list, new ShortCalculator());
                return (T) ss;
            case "Long":
                CalcNumbers<Long> l = new CalcNumbers<>();
                Long sl =  l.sumValue((List<Long>) list, new LongCalculator());
                return (T) sl;
            case "Byte":
                CalcNumbers<Byte> b = new CalcNumbers<>();
                Byte sb =  b.sumValue((List<Byte>) list, new ByteCalculator());
                return (T) sb;
        }
        return null;
    }
    public void splitter(T item) {
        switch (clazz) {
            case "Integer":
                CalcNumbers<Integer> i = new CalcNumbers<>();
                i.divideList((List<Integer>) list, new IntegerCalculator(), item.intValue());
                break;
            case "Double":
                CalcNumbers<Double> d = new CalcNumbers<>();
                d.divideList((List<Double>) list, new DoubleCalculator(), item.doubleValue());
                break;
            case "Float":
                CalcNumbers<Float> f = new CalcNumbers<>();
                f.divideList((List<Float>) list, new FloatCalculator(), item.floatValue());
                break;
            case "Short":
                CalcNumbers<Short> s = new CalcNumbers<>();
                s.divideList((List<Short>) list, new ShortCalculator(), item.shortValue());
                break;
            case "Long":
                CalcNumbers<Long> l = new CalcNumbers<>();
                l.divideList((List<Long>) list, new LongCalculator(), item.longValue());
                break;
            case "Byte":
                CalcNumbers<Byte> b = new CalcNumbers<>();
                b.divideList((List<Byte>) list, new ByteCalculator(), item.byteValue());
                break;
        }
    }

    static class CalcNumbers<T extends Number> {
        public T sumValue(List<T> list, Calculator<T> calculator) {
            T total = calculator.zero();
            for (T n : list) {
                total = calculator.add(total, n);
            }
            return total;
        }
        public void divideList(List<T> list, Calculator<T> calculator, T item) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, calculator.divide(list.get(i), item));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathBox)) return false;
        MathBox<?> mathBox = (MathBox<?>) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return super.list.toString();
    }
}
