package hu.elte.view;

import hu.elte.entity.HighScore;

import javax.swing.*;
import java.awt.*;

import java.util.List;

public class HighScoreDialog extends JDialog {

    public HighScoreDialog(JFrame frame, String name , List<HighScore> result) {
        super(frame, name, true);
        JPanel p = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        for(HighScore score: result) {
            JTextField textfield = new JTextField(25);
            p.add(textfield);
            textfield.setText(String.valueOf(score));
            add(p);
            pack();
        }

        setSize(400, 400);
        setVisible(true);
    }
}
