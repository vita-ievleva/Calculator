package dp.vita.ui.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private static final String[] DIGIT_PANEL_BUTTON_NAMES = {"7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0" };

    protected static final String[] ACTION_BUTTONS_NAMES = {"/", "*", "-", "+"};
    private static  JTextField textField;

    CalculatorActionListener outerListener;

    public MainFrame() {

        outerListener = new CalculatorActionListener();
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel inputFieldPanel = createInputPanel();
        JPanel digitPanel = createDigitPanel();

        JButton cleanButton = new JButton("C");
        cleanButton.addActionListener(outerListener.new CleanListener(textField));

        JButton pointButton = new JButton(".");
        pointButton.addActionListener(outerListener.new PointerListener(textField));

        digitPanel.add(pointButton);
        digitPanel.add(cleanButton);

        JPanel actionPanel = new JPanel(new GridLayout(2, 1));

        JPanel upperActionPanel = createUpperActionPanel();
        JPanel lowerPanel = new JPanel(new BorderLayout());

        JButton buttonEqual = new JButton("=");
        JButton buttonDeleteChar = new JButton("<");

        buttonDeleteChar.addActionListener(outerListener.new DeleteSymbolListener(textField));
        buttonEqual.addActionListener(outerListener.new ResultListener(textField));

        lowerPanel.add(buttonEqual, BorderLayout.SOUTH);
        lowerPanel.add(buttonDeleteChar, BorderLayout.NORTH);

        actionPanel.add(upperActionPanel, BorderLayout.NORTH);
        actionPanel.add(lowerPanel, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputFieldPanel, BorderLayout.NORTH);
        mainPanel.add(digitPanel, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.EAST);

        frame.add(mainPanel);
        frame.pack();

        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel inputFieldPanel = new JPanel(new BorderLayout());
        textField = new JTextField(16);
        textField.setFont(new Font("sansserif", Font.BOLD, 16));
        inputFieldPanel.add(textField, BorderLayout.CENTER);

        return inputFieldPanel;
    }

    private JPanel createDigitPanel() {
        JPanel digitPanel = new JPanel(new GridLayout(4, 3));

        for (String name : DIGIT_PANEL_BUTTON_NAMES) {
            JButton button = new JButton(name);
            digitPanel.add(button);
            button.addActionListener(outerListener.new NumberListener(textField));
        }
        return digitPanel;
    }

    private JPanel createUpperActionPanel() {
        JPanel upperActionPanel = new JPanel(new GridLayout(2, 2));

        for (String name : ACTION_BUTTONS_NAMES) {
            JButton button = new JButton(name);
            upperActionPanel.add(button);
            button.addActionListener(outerListener.new ActionsListener(textField));
        }
        return upperActionPanel;
    }
}