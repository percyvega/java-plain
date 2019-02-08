package com.percyvega.experiments.swing;

/**
 * Created by Percy on 1/7/2015.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener {

    JLabel litersL;
    JTextField litersTF;
    JButton m2e;

    public MyJFrame() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(2, 3));

        litersL = new JLabel("Liters");
        c.add(litersL);
        litersTF = new JTextField(10);
        c.add(litersTF);

        m2e = new JButton("Convert Kilograms to Pints");
        m2e.setActionCommand("m2u");
        m2e.addActionListener(this);
        c.add(m2e);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("m2u")) {
            double val = Double.valueOf(litersTF.getText()).doubleValue();
            litersL.setText(new Double(val * 2.113).toString());
        }
    }

    public static void main(String[] args) {
        MyJFrame frame = new MyJFrame();
        frame.pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(screenSize.width / 2 - frame.getWidth() / 2,
                screenSize.height / 2 - frame.getHeight() / 2);
        frame.setVisible(true);
    }

}