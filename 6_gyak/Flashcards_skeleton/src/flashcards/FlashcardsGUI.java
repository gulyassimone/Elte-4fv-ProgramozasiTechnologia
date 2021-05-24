package flashcards;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FlashcardsGUI {

    private List<Card> cards;
    private int cardNumber;
    private boolean showQuestion;
    private int score;

    private JFrame frame;
    private JPanel northPanel;
    private JPanel southPanel;
    private JTextArea display;
    private JLabel scoreLabel;

    public FlashcardsGUI() {
        frame = new JFrame("Flashcards");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        northPanel = new JPanel();
        display = new JTextArea("Please open a cards file.", 10, 40);
        display.setEditable(false);
        display.setLineWrap(true);
        display.setWrapStyleWord(true);
        northPanel.add(display);
        frame.getContentPane().add(northPanel, BorderLayout.NORTH);

        southPanel = new JPanel();
        scoreLabel = new JLabel("0/0");
        southPanel.add(scoreLabel);
        ArrayList<String> buttonLabels = new ArrayList<>(
            Arrays.asList("Reset", "Toggle Q/A", "Wrong answer", "Good answer"));
        ArrayList<ActionListener> listeners = new ArrayList<>(
            Arrays.asList(new ResetButtonActionListener(),
                new ToggleButtonActionListener(),
                new AnswerButtonActionListener(false),
                new AnswerButtonActionListener(true)));

        for (int i = 0; i < buttonLabels.size(); ++i) {
            JButton button = new JButton(buttonLabels.get(i));
            southPanel.add(button);
            button.addActionListener(listeners.get(i));
        }
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem openMenuItem = new JMenuItem("Open...");
        openMenuItem.addActionListener(new OpenActionListener());
        fileMenu.add(openMenuItem);
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public void reset() {
        score = 0;
        cardNumber = 0;
        showQuestion = true;
        updateScore();
        updateDisplay();
    }

    private void updateScore() {
        scoreLabel.setText(score + "/" + cardNumber);
    }

    private void updateDisplay() {
        if (cards != null && cardNumber < cards.size()) {
            if (showQuestion) {
                display.setText(cards.get(cardNumber).getQuestion());
            } else {
                display.setText(cards.get(cardNumber).getAnswer());
            }
        } else if (cards != null) {
            display.setText("The End");
        }
    }

    class OpenActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                // ...
            }
        }
    }

    class ToggleButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
 
        }

    }

    class ResetButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
 
        }

    }

    class AnswerButtonActionListener implements ActionListener {

        private boolean incScore;

        public AnswerButtonActionListener(boolean incScore) {
            this.incScore = incScore;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }

    }

}
