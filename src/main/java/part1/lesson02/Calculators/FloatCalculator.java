package part1.lesson02.Calculators;

import part1.lesson02.Calculators.Calculator;

public class FloatCalculator implements Calculator<Float> {
    @Override
    public Float zero() {
        return 0f;
    }

    @Override
    public Float add(Float o1, Float o2) {
        return o1 + o2;
    }

    @Override
    public Float divide(Float o1, Float o2) {
        return  o1 / o2;
    }
}
