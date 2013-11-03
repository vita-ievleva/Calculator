package dp.vita;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {
    private JFrame frame;

    public MainFrame() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Calculator");
        frame.setLayout(new CardLayout());


        for( int i = 0; i < 10; i++) {

             frame.add( new JButton( "" + i) );

        }


        JButton button = new JButton("Button");
        JButton exit = new JButton("Exit");
        JTextField textBox = new JFormattedTextField();
        frame.add(textBox, BorderLayout.NORTH);
        exit.addActionListener(new ButtonListener());
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,1,5,5));
        jPanel.add(button);
        jPanel.add(exit);
        frame.add(jPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setSize(250, 360);

    }

}

class ButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if("exit".equalsIgnoreCase(e.getActionCommand())){
            System.exit(0);
        }
    }
}


class GraphicInterfaceTest {
    public static void main(String[] args) {
        MainFrame graphicInterface = new MainFrame();

    }

}




