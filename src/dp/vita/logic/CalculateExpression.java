package dp.vita.logic;

import dp.vita.Exception.ZeroDivideException;
import java.util.List;

public class CalculateExpression {

    public static double calculate(List<Double> values, List<Character> operations)
            throws ZeroDivideException {
        int divideIndex = -1,
            multiplyIndex = -1,
            plusIndex = -1,
            minusIndex = -1;

        while ((divideIndex = operations.indexOf('/')) != -1) {
            if (values.get(divideIndex + 1) == 0) throw new ZeroDivideException("Divisor is Zero");

            values.set(divideIndex, values.get(divideIndex) / values.get(divideIndex + 1));
            values.remove(divideIndex + 1);
            operations.remove(divideIndex);
        }

        while ((multiplyIndex = operations.indexOf('*')) != -1) {
            values.set(multiplyIndex, values.get(multiplyIndex) * values.get(multiplyIndex + 1));
            values.remove(multiplyIndex + 1);
            operations.remove(multiplyIndex);
        }

        while ((minusIndex = operations.indexOf('-')) != -1 ||
               (plusIndex = operations.indexOf('+')) != -1) {

            if (minusIndex != -1) {
                values.set(minusIndex, values.get(minusIndex) - values.get(minusIndex + 1));
                values.remove(minusIndex + 1);
                operations.remove(minusIndex);
            }

            if (plusIndex != -1) {
                values.set(plusIndex, values.get(plusIndex) + values.get(plusIndex + 1));
                values.remove(plusIndex + 1);
                operations.remove(plusIndex);
            }

        }
        return values.get(0);
    }
}
