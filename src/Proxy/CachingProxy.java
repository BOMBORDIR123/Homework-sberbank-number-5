package Proxy;

import java.util.HashMap;
import java.util.Map;
import Calculator.Calculator;

public class CachingProxy implements Calculator {
    private final Calculator calculator;
    private final Map<Integer, Integer> cache = new HashMap<>();

    public CachingProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int number) {
        if (cache.containsKey(number)) {
            return cache.get(number);
        }
        int result = calculator.calc(number);
        cache.put(number, result);
        return result;
    }
}

