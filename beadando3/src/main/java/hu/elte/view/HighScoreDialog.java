package hu.elte.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoreDialog extends JDialog {

    public HighScoreDialog(JFrame frame, String name ) {
        super(frame, name);
        JButton closeIt = new JButton("OK");
        closeIt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Closing dialog");
                dispose();
            }
        });
        getContentPane().add(closeIt, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
        getContentPane().add(new JLabel("Placeholder label"));
        pack();
        setSize(200, 200);
        setVisible(true);
        setVisible(true);
    }
}
