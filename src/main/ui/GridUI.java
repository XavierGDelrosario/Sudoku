package ui;

import model.Group;
import model.Square;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Representation of a 3x3 grid in sudoku
public class GridUI extends JPanel {
    private final List<SquareUI> squares;

    //EFFECTS: creates graphical representation of 3x3 grid
    public GridUI() {
        squares = new ArrayList<>();
        setLayout(new GridLayout(3, 3, 0, 0));
        setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.BLACK));
        for (int i = 1; i <= 9; i++) {
            SquareUI btn = new SquareUI();
            squares.add(btn);
            add(btn);
            btn.setActionCommand("select");
            btn.addActionListener(Listener.getInstance());
        }
        setVisible(true);
    }

    //REQUIRES: squares size = 9, organized top-down, left-right
    //MODIFIES: squareUI in squares
    //EFFECTS: assigns given squares to corresponding UI representation
    public void assignSquares(Group group) {
        List<Square> squares = group.getSquares();
        for (int i = 0; i < 9; i++) {
            this.squares.get(i).setSquare(squares.get(i));
        }
        update();
    }

    //MODIFIES: squareUI squares
    //EFFECTS: updates all squares to show their current value
    public void update() {
        for (SquareUI square : squares) {
            square.update();
        }
    }
}
