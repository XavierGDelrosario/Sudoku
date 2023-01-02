package ui;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    public static int FRAME_WIDTH = 700;
    public static int FRAME_HEIGHT = 700;

    private final BoardUI board;
    private final UserInputUI userInput;
    private Label label;

    public ApplicationFrame() {
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(206, 206, 206));
        getContentPane().setLayout(new GridBagLayout());
        board = new BoardUI();
        userInput = new UserInputUI();
        addComponents();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void addComponents() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 3.5;
        constraints.weightx = 2.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(board, constraints);

        constraints.gridy = 2;
        constraints.weighty = 1.0;
        add(userInput,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 0.25;
        label = new Label("");
        add(label, constraints);
    }

    //EFFECTS: sets text of label
    public void setLabel(String text) {
        label.setText(text);
    }

    public BoardUI getBoard() {
        return board;
    }
}
