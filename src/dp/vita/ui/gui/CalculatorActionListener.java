package dp.vita.ui.gui;

import dp.vita.logic.CalculateExpression;
import dp.vita.logic.Parser;
import dp.vita.Exception.ZeroDivideException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorActionListener  {

    private static final String EMPTY_VALUE = "";
    private JTextField textField;
    private boolean isResultCalculated = false;

    class NumberListener implements ActionListener {

         NumberListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            char pressedKey = e.getActionCommand().charAt(0);

            if (isResultCalculated) {
                textField.setText(EMPTY_VALUE + pressedKey);
                isResultCalculated = false;
            } else {
                textField.setText(textField.getText() + pressedKey);
            }
        }
    }

    class ActionsListener implements ActionListener {

         ActionsListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            char pressedKey = e.getActionCommand().charAt(0);

            if(isResultCalculated) textField.setText(EMPTY_VALUE);

            else if(!(textField.getText().isEmpty()))
                textField.setText(textField.getText() + pressedKey);
        }
    }

    class PointerListener implements ActionListener {

         PointerListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            char pressedKey = e.getActionCommand().charAt(0);

            if (!textField.getText().isEmpty())
                textField.setText(textField.getText() + pressedKey);
        }
    }

    class DeleteSymbolListener implements ActionListener {

         DeleteSymbolListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String stringFromField = textField.getText();

            if(!stringFromField.isEmpty())
                textField.setText(stringFromField.substring(0, stringFromField.length() - 1));
        }
    }

    class CleanListener implements ActionListener {

         CleanListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textField.setText(EMPTY_VALUE);
        }
    }

    class ResultListener implements ActionListener {

         ResultListener(JTextField textField) {
            CalculatorActionListener.this.textField = textField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!textField.getText().isEmpty()) {
                try {
                    double result =
                            CalculateExpression.calculate(Parser.getNumbers(textField.getText()),
                                                          Parser.getActions(textField.getText()));

                    textField.setText(Double.toString(result));

                } catch (ZeroDivideException e2) {
                    textField.setText("Division by zero is forbidden");

                } finally {
                    isResultCalculated = true;
                }
            }
        }
    }
}
