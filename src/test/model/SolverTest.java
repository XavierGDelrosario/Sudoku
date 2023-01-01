package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolverTest {
    private Solver solver;
    private Puzzle puzzle;

    @BeforeEach
    public void setup() {
        solver = new Solver();
        puzzle = new Scraper().createPuzzle();
    }

    @Test
    public void testSolve() {
        Puzzle solution = solver.solve(puzzle);
        assertTrue(solution.isSolved());

        displayBoard(puzzle);
        System.out.println("____________________________");
        displayBoard(solution);
    }

    private void displayBoard(Puzzle puzzle) {
        List<Group> rows = puzzle.getRows();
        for (Group row : rows) {
            System.out.println(row.getValues());
        }
    }
}
