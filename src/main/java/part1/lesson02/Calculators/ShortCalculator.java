package part1.lesson02.Calculators;

import part1.lesson02.Calculators.Calculator;

public class ShortCalculator implements Calculator<Short> {
    @Override
    public Short zero() {
        return 0;
    }

    @Override
    public Short add(Short o1, Short o2) {
        return (short) (o1 + o2);
    }

    @Override
    public Short divide(Short o1, Short o2) {
        return (short) (o1 / o2);
    }
}
