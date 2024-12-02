package Calculator;

import Annotations.Metric;

public interface Calculator {
    @Metric
    int calc(int number);
}
