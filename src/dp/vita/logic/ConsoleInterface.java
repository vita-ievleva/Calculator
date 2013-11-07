package dp.vita.logic;

import dp.vita.logic.Calculator;
import dp.vita.logic.ZeroDivideException;

import java.util.Scanner;

/**
 * Created by admin on 25.10.13.
 */
public class ConsoleInterface {

    public static void calcConsoleInterface() throws ZeroDivideException {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first argument: ");
        double firstValue = in.nextDouble();

        System.out.println("Enter second argument: ");
        double secondValue = in.nextDouble();

        System.out.println("Enter action argument: ");
        char action = in.next().charAt(0);


        try {
            double res = Calculator.calculate(firstValue, secondValue, action);
            System.out.println(firstValue + " " + action + " " + secondValue + " = " + res );

        } catch (ZeroDivideException e) {
            System.out.println( "Make me happy and do not try to divide by zero!" );
        }

    }
}
