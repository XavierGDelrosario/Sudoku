package model;

import java.util.ArrayList;
import java.util.List;

//Solves a given Sudoku puzzle
public class Solver {

    public Solver() {
    }

    //EFFECTS: solves and returns given puzzle
    public Puzzle solve (Puzzle puzzle) {
        if (puzzle.isSolved()) {
            return puzzle;
        }
        List<Puzzle> attempts = createAttempts(puzzle);
        for (Puzzle attempt : attempts) {
            if (attempt.isSolved()) {
                return attempt;
            }
        }
        return solve(attempts);
    }

    //REQUIRES: puzzles are different attempts of the same board
    //EFFECTS: solves and returns a solution from given puzzle
    public Puzzle solve (List<Puzzle> puzzles) {

        List<Puzzle> attempts = new ArrayList<>();
        for (Puzzle puzzle : puzzles) {
            attempts.addAll(createAttempts(puzzle));
        }
        for (Puzzle attempt : attempts) {
            if (attempt.isSolved()) {
                return attempt;
            }
        }
        return solve(attempts);
    }

    //EFFECTS: returns a list of attempts for a puzzle, find an empty square and tries 1-9, returns all valid attempts
    private List<Puzzle> createAttempts(Puzzle puzzle) {
        List<Puzzle> attempts = new ArrayList<>();
        int index = puzzle.getValues().indexOf(0);
        List<Integer> values = puzzle.getValues();
        for (int i = 1; i <= 9; i++) {
            Puzzle newAttempt = createAttempt(i, index, values);
            if (newAttempt != null) {
                attempts.add(newAttempt);
            }
        }
        return attempts;
    }

    //EFFECTS: creates a puzzle with given values and changes index to given value
    private Puzzle createAttempt(int value, int index, List<Integer> values) {
        if (index != -1) {
            Puzzle attempt = new Puzzle(values);
            attempt.getSquares().get(index).setValue(value);
            if (attempt.isValid()) {
                return attempt;
            }
        }
        return null;
    }
}
