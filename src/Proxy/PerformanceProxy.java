package Proxy;

import Annotations.Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import Calculator.Calculator;

public class PerformanceProxy implements InvocationHandler {
    private final Calculator calculator;

    public PerformanceProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(calculator, args);
            long endTime = System.nanoTime();
            System.out.println("Время работы метода: " + (endTime - startTime) + " (в наносекундах)");
            return result;
        }
        return method.invoke(calculator, args);
    }

    public static Calculator createProxy(Calculator calculator) {
        return (Calculator) Proxy.newProxyInstance(
                calculator.getClass().getClassLoader(),
                calculator.getClass().getInterfaces(),
                new PerformanceProxy(calculator)
        );
    }
}

