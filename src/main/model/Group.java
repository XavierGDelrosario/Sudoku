package model;

import java.util.ArrayList;
import java.util.List;


//Represents a group of squares inside a sudoku puzzle, rows, columns, or 3x3 grid
public class Group {
    private final List<Square> squares;

    //REQUIRES: squares size = 9
    //EFFECTS: creates a representation of a group
    public Group (List<Square> squares) {
        this.squares = squares;
    }

    //EFFECTS: returns true if there is at most one occurrence of numbers 1-9
    public boolean isValid() {
        List<Square> testSquares = new ArrayList<>(squares);
        return isValid(testSquares);
    }

    //EFFECTS: returns true if there is at most one occurrence of numbers 1-9
    private boolean isValid(List<Square> squares) {
        if (squares.size() == 0) {
            return true;
        }
        Square testSquare = squares.remove(0);
        for (Square square : squares) {
            if (testSquare.getValue() == square.getValue() && testSquare.getValue() != 0) {
                return false;
            }
        }
        return isValid(squares);
    }

    public List<Square> getSquares() {
        return squares;
    }

    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (Square square: squares) {
            values.add(square.getValue());
        }
        return values;
    }
}
