package Impl;

import Calculator.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
