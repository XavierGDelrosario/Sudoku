package model;

import java.util.ArrayList;
import java.util.List;

//Represents a sudoku puzzle
public class Puzzle {
    private final List<Square> squares;
    private final List<Group> rows;
    private final List<Group> columns;
    private final List<Group> grids;

    //REQUIRES: values [0, 9], values size == 81
    //EFFECTS: creates a sudoku puzzle from values, values read row by row
    public Puzzle(List<Integer> values) {
        squares = new ArrayList<>();
        for (int i : values) {
            squares.add(new Square(i));
        }
        rows = new ArrayList<>();
        columns = new ArrayList<>();
        grids = new ArrayList<>();

        createRowsAndColumns();
        createGrids();
        }

    //MODIFIES: this
    //EFFECTS: groups squares into 3x3 grids
    private void createGrids() {
        for (int i = 0; i < 55; i += 27) {
            for (int j = 0; j < 3; j ++) {
                List<Square> grid = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        grid.add(squares.get(i + j * 3 + k * 9 + l));
                    }
                }
                grids.add(new Group(grid));
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: groups squares into rows and columns
    private void createRowsAndColumns() {

        for (int i = 0; i < 9; i++) {
            List<Square> row = new ArrayList<>();
            List<Square> column = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(squares.get(i * 9 + j));
                column.add(squares.get(i + j * 9));
            }
            rows.add(new Group(row));
            columns.add(new Group(column));
        }
    }

    //EFFECTS: returns true if there is at most one occurrence of numbers 1-9 in each row, column, and each 3x3 square
    public boolean isValid() {
        for (int i = 0; i < 9; i++) {
            if (!rows.get(i).isValid() || !columns.get(i).isValid() || !grids.get(i).isValid()) {
                return false;
            }
        }
        return true;
    }

    //EFFECTS: returns true there is no empty square and puzzle is valid
    public boolean isSolved() {
        List<Integer> values = getValues();
        return !values.contains(0) && isValid();
    }

    public List<Square> getSquares() {
        return squares;
    }

    public List<Group> getRows() {
        return rows;
    }

    public List<Group> getColumns() {
        return columns;
    }

    public List<Group> getGrids() {
        return grids;
    }

    //EFFECTS: returns values of all squares
    public List<Integer> getValues() {
        List<Integer> values = new ArrayList<>();
        for (Square square: squares) {
            values.add(square.getValue());
        }
        return values;
    }
}
