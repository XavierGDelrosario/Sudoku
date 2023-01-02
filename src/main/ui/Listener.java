package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Represents Listener for all actions
public class Listener implements ActionListener {
    private static Listener SINGLETON = new Listener();

    private Listener() {
    }

    public static Listener getInstance() {
        return SINGLETON;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        SudokuGUI.getInstance().actionPerformed(e);
    }
}
