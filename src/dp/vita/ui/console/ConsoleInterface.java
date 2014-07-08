package dp.vita.ui.console;

import dp.vita.logic.CalculateExpression;
import dp.vita.Exception.ZeroDivideException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {

    public static void calcConsoleInterface() throws ZeroDivideException {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first argument:");
        double firstValue = in.nextDouble();


        System.out.println("Enter second argument:");
        double secondValue = in.nextDouble();

        System.out.println("Enter action argument:");
        char action = in.next().charAt(0);

        try {
            List<Double> values = new ArrayList<>(Arrays.asList(firstValue, secondValue) );
            List<Character> actionOnValues = new ArrayList<>( Arrays.asList(action) );

            double res = CalculateExpression.calculate(values, actionOnValues);
            System.out.println("Result = " + res );

        } catch (ZeroDivideException e) {
            System.out.println( "Make me happy and do not try to divide by zero!" );
        }

    }
}
