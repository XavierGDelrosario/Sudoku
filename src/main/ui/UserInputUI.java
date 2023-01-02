package ui;

import javax.swing.*;
import java.awt.*;

//Represents panel containing user input
public class UserInputUI extends JPanel {

    //EFFECTS: creates new panel
    public UserInputUI() {
        setLayout(new GridLayout());
        setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.BLACK));
        createInputPad();
        JButton solve = new JButton("Solve");
        solve.setActionCommand("solve");
        solve.addActionListener(Listener.getInstance());

        JButton newPuzzle = new JButton("New Puzzle");
        newPuzzle.setActionCommand("newPuzzle");
        newPuzzle.addActionListener(Listener.getInstance());

        add(newPuzzle);
        add(solve);
        setVisible(true);
    }

    //EFFECTS: creates the 3x3 grid of buttons with numbers 1-9
    private void createInputPad() {
        JPanel numberPad = new JPanel();
        numberPad.setLayout(new GridLayout(3, 3, 0, 0));
        numberPad.setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.BLACK));

            for (int i = 1; i < 10; i++) {
                JButton btn = new JButton(Integer.toString(i));
                numberPad.add(btn);
                btn.setActionCommand("newValue");
                btn.addActionListener(Listener.getInstance());
                btn.setVisible(true);
            }

        numberPad.setVisible(true);
        add(numberPad);
    }
}
