package main.java.com.antispam.plaf;

import main.java.com.antispam.calculator.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

/**
 * Created by yangshenneng on 14/11/10.
 */
public class PlafFrame extends JFrame {
    private JPanel buttonPanel;
    public PlafFrame() {
        buttonPanel = new JPanel();
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(),info.getClassName());
        }
        //add(buttonPanel);
        JPanel calculator = new Calculator();
        add(calculator);
        pack();
    }

    void makeButton(String name, final String plafName) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                    pack();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new PlafFrame();
                frame.setTitle("my image");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
