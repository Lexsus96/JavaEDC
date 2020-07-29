package part1.lesson02.Calculators;

public class ByteCalculator implements Calculator<Byte> {
    @Override
    public Byte zero() {
        return 0;
    }

    @Override
    public Byte add(Byte o1, Byte o2) {
        return  (byte) (o1 + o2);
    }

    @Override
    public Byte divide(Byte o1, Byte o2) {
        return (byte) (o1 / o2);
    }
}
