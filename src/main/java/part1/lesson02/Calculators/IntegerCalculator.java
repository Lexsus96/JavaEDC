package part1.lesson02.Calculators;

import part1.lesson02.Calculators.Calculator;

public class IntegerCalculator implements Calculator<Integer> {

    @Override
    public Integer zero() {
        return 0;
    }

    @Override
    public Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override
    public Integer divide(Integer o1, Integer o2) {
        return o1 / o2;
    }
}
