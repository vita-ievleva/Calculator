package dp.vita.logic;

import java.util.ArrayList;

public class Parser {

    private static final String REGEX_TO_GET_ACTIONS = "[0-9,.]+";
    private static final String REGEX_TO_GET_NUMBERS = "[-+/*]+";

    public static ArrayList<Character> getActions(String s) {
        String[] actions = s.split(REGEX_TO_GET_ACTIONS);

        ArrayList<Character> actChars = new ArrayList<>();
        for (int i = 0, j = 1; j < actions.length; j++) {
            actChars.add(i, actions[j].charAt(0));
            i++;
        }
        return actChars;
    }

    public static ArrayList<Double> getNumbers(String s) {
        String[] numbers = s.split(REGEX_TO_GET_NUMBERS);

        ArrayList<Double> numberList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            numberList.add(i, Double.parseDouble(numbers[i]));
        }
        return numberList;
    }
}
