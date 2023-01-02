package ui;

import model.Puzzle;
import model.Solver;
import model.Square;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//Represents the GUI
public class SudokuGUI implements ActionListener {
    private static SudokuGUI SINGLETON = new SudokuGUI();
    private Solver solver;
    private ApplicationFrame application;
    private Square selected;

    //EFFECTS: creates new sudoku ui
    private SudokuGUI() {
        application = new ApplicationFrame();
        solver = new Solver();
        selected = null;
    }

    public static SudokuGUI getInstance() {
        return SINGLETON;
    }

    //EFFECTS: returns true if given change is valid
    private boolean testIsValid(int value, int index) {
        List<Integer> values = getPuzzle().getValues();
        Puzzle puzzle = new Puzzle(values);
        Square square = puzzle.getSquares().get(index);
        square.setValue(value);
        return puzzle.isValid();
    }

    //REQUIRES: selected is changeable
    //MODIFIES: squareUI
    //EFFECTS: changes value of selected square if it is valid
    private void changeValue(JButton source) {
        int index = getPuzzle().getSquares().indexOf(selected);
        int value = Integer.parseInt(source.getText());
        if (testIsValid(value, index)) {
            selected.setValue(value);
            getBoard().update();
        } else {
            application.setLabel("Given input is not valid");
        }
    }

    @Override
    //EFFECTS: performs functions when buttons are pressed
    public void actionPerformed(ActionEvent e) {
        application.setLabel("");
        if (e.getActionCommand().equals("select")) {
            getBoard().update();
            SquareUI square = (SquareUI) e.getSource();
            square.select();
            selected = square.getSquare();
        } else if (e.getActionCommand().equals("solve")) {
            Puzzle solvedPuzzle = solver.solve(new Puzzle(getPuzzle().getInitialValues()));
            if (solvedPuzzle != null) {
                getBoard().drawBoard(solvedPuzzle);
            }
            selected = null;
        } else if (e.getActionCommand().equals("newPuzzle")) {
            getBoard().drawBoard();
            selected = null;
        } else if (e.getActionCommand().equals("newValue")) {
            if (selected != null) {
                if (selected.isChangeable()) {
                   changeValue((JButton) e.getSource());
                } else {
                    application.setLabel("Selected square cannot be changed");
                }
            } else {
                application.setLabel("No squares selected");
            }
        }
    }

    private BoardUI getBoard() {
        return application.getBoard();
    }

    private Puzzle getPuzzle() {
        return application.getBoard().getCurrentPuzzle();
    }

}
