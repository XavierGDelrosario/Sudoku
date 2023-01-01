package model;

//Represents a square in a sudoku puzzle
public class Square {
    private int value;
    private final boolean changeable;

    //REQUIRES: i [0, 9]
    //EFFECTS: creates a square in a sudoku board, is not changeable if given 0
    public Square (int i) {
        value = i;
        changeable = value == 0;
    }

    //EFFECTS: if changeable set value to given value and return true, else return false
    public boolean setValue(int i) {
        if (changeable) {
            value = i;
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public boolean isChangeable () {
        return changeable;
    }
}
