package ui;

import model.Square;

import javax.swing.*;
import java.awt.*;

public class SquareUI extends JButton {
    private Square square;

    //EFFECTS: creates UI representation of square
    public SquareUI() {
        square = null;
        setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: updates text to correct number and color. black is given and blue if user inputted value, changes
    //          background to white
    public void update() {
        if (square == null || square.getValue() == 0) {
            setText("");
        } else {
            setText(String.valueOf(square.getValue()));
            if (square.isChangeable()) {
                setForeground(Color.BLUE);
            } else {
                setForeground(Color.BLACK);
            }
        }
        setBackground(new Color(234, 233, 233));
    }

    //MODIFIES: this
    //EFFECTS: changes background to grey
    public void select() {
        setBackground(new Color(192, 192, 192));
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }
}
