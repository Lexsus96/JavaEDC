package part1.lesson02.Calculators;

import part1.lesson02.Calculators.Calculator;

public class LongCalculator implements Calculator<Long> {
    @Override
    public Long zero() {
        return (long) 0;
    }

    @Override
    public Long add(Long o1, Long o2) {
        return o1 + o2;
    }

    @Override
    public Long divide(Long o1, Long o2) {
        return o1 / o2;
    }
}
