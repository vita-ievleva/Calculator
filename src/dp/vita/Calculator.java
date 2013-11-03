package dp.vita;

/**
 * Написать класс калькулятор,
 * метод калкулейт, примимает в себя два дабла и 1 чар (операция +-делить и умножить)
 * со свичом
 * 4.1 Свой класс исключения: если делание на ноль то бросать свое исключение.
 * 4.2 написать класс консоль интерфейс, чтобы можно было пользоваться из консоли
 * <p/>
 * Created by admin on 21.10.13.
 */

public class Calculator {

    public static double calculate(double firstValue, double secondValue, char action) throws ZeroDivideException {
        double res = 0;

        switch (action) {
            case '*':
                res = firstValue * secondValue;
                break;

            case '+':
                res = firstValue + secondValue;
                break;

            case '-':
                res = firstValue - secondValue;
                break;

            case '/':
                if (secondValue == 0) {
                    throw new ZeroDivideException("divisor == 0");
                } else {
                    res = firstValue / secondValue;
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
      return res;
    }
}
