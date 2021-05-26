package hu.elte.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameDialog extends JDialog {
    private int points;
    private JTextField name;
    private JPanel btnPanel;
    private JButton btn ;

    public EndGameDialog(JFrame frame, String msg, int points) {
        this.points = points;
        this.name = new JTextField(30);
        btnPanel = new JPanel(new FlowLayout());
        btn = new JButton ("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( processAccept() )
                {
                   setVisible(false);
                }
            }
        });

        btnPanel.add( this.name);
        btnPanel.add(btn);
        add(btnPanel);

        this.pack();
        setVisible(true);

    }
    protected boolean processAccept() {
        if (this.name.getText().equals("")) {
            return false;
        } else {
            HighScoreManager highScores = new HighScoreManager();
            highScores.putHighScore( this.name.getText(), this.points);
            return true;
        }
    }

}
