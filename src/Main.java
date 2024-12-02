import Constants.MyConstants;
import Impl.CalculatorImpl;
import Methods.ConstantChecker;
import Methods.GetterPrinter;
import Methods.MethodPrinter;
import Proxy.CachingProxy;
import Proxy.PerformanceProxy;
import Utils.BeanUtils;
import Calculator.Calculator;
import Entity.Source;
import Entity.Destination;

public class Main {
    public static void main(String[] args) {
        // Задача 1: Тестирование Calculator
        Calculator calculator = new CalculatorImpl();

        Calculator proxyCalculator = PerformanceProxy.createProxy(calculator);
        System.out.println("Факториал числа 5: " + proxyCalculator.calc(5));

        // Задача 2: Вывод всех методов CalculatorImpl
        System.out.println("\nМетоды класса CalculatorImpl:");
        MethodPrinter.printAllMethods(CalculatorImpl.class);

        // Задача 3: Вывод всех геттеров CalculatorImpl
        System.out.println("\nГеттеры класса CalculatorImpl:");
        GetterPrinter.printGetters(CalculatorImpl.class);

        // Задача 4: Проверка значений констант
        System.out.println("\nПроверка значений констант:");
        ConstantChecker.checkStringConstants(MyConstants.class);

        // Задача 5: Тестирование кэширования
        Calculator cachingCalculator = new CachingProxy(calculator);
        System.out.println("\nКэширование:");
        System.out.println("Результат для 5: " + cachingCalculator.calc(5));
        System.out.println("Результат для 5 (повтор): " + cachingCalculator.calc(5));

        // Задача 6: Тестирование PerformanceProxy с аннотацией Metric
        System.out.println("\nPerformance Proxy:");
        System.out.println("Результат для 3 с измерением времени: " + proxyCalculator.calc(3));

        // Задача 7: Тестирование BeanUtils
        Source source = new Source();
        Destination destination = new Destination();

        BeanUtils.assign(destination, source);

        System.out.println("\nBeanUtils копирование данных:");
        System.out.println("Destination название: " + destination.getName());
        System.out.println("Destination значение: " + destination.getValue());
    }
}
