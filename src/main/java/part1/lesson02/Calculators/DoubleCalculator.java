package part1.lesson02.Calculators;

import part1.lesson02.Calculators.Calculator;

public class DoubleCalculator implements Calculator<Double> {
    @Override
    public Double zero() {
        return 0.0;
    }

    @Override
    public Double add(Double o1, Double o2) {
        return o1 + o2;
    }

    @Override
    public Double divide(Double o1, Double o2) {
        return o1 / o2;
    }
}
