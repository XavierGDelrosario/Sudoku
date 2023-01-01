package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PuzzleTest {
    private Puzzle solvedPuzzle;
    private Puzzle invalidRowPuzzle;
    private Puzzle invalidColumnPuzzle;
    private Puzzle invalidGridPuzzle;
    private Puzzle incompletePuzzle;

    @BeforeEach
    public void setup() {
        List<Integer> solvedValues = new ArrayList<>(Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6,
                                                                   9, 6, 5, 3, 2, 7, 1, 4, 8,
                                                                   3, 4, 1, 6, 8, 9, 7, 5, 2,
                                                                   5, 9, 3, 4, 6, 8, 2, 7, 1,
                                                                   4, 7, 2, 5, 1, 3, 6, 8, 9,
                                                                   6, 1, 8, 9, 7, 2, 4, 3, 5,
                                                                   7, 8, 6, 2, 3, 5, 9, 1, 4,
                                                                   1, 5, 4, 7, 9, 6, 8, 2, 3,
                                                                   2, 3, 9, 8, 4, 1, 5, 6, 7));

        List<Integer> invalidRowValues = new ArrayList<>(Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6,
                                                                       9, 6, 5, 3, 2, 7, 1, 4, 8,
                                                                       3, 4, 1, 6, 8, 9, 7, 5, 2,
                                                                       5, 9, 3, 4, 6, 8, 2, 7, 1,
                                                                       4, 7, 2, 5, 1, 3, 6, 8, 9,
                                                                       6, 1, 8, 9, 7, 2, 4, 3, 5,
                                                                       7, 8, 6, 2, 3, 5, 9, 1, 4,
                                                                       1, 5, 4, 7, 9, 6, 8, 0, 3,
                                                                       2, 3, 9, 8, 4, 1, 5, 2, 7));

        List<Integer> invalidColumnValues = new ArrayList<>(Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6,
                                                                          9, 6, 5, 3, 2, 7, 1, 4, 8,
                                                                          3, 4, 1, 6, 8, 9, 7, 0, 5,
                                                                          5, 9, 3, 4, 6, 8, 2, 7, 1,
                                                                          4, 7, 2, 5, 1, 3, 6, 8, 9,
                                                                          6, 1, 8, 9, 7, 2, 4, 3, 5,
                                                                          7, 8, 6, 2, 3, 5, 9, 1, 4,
                                                                          1, 5, 4, 7, 9, 6, 8, 2, 3,
                                                                          2, 3, 9, 8, 4, 1, 5, 6, 7));
        List<Integer> invalidGridValues = new ArrayList<>(Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6,
                                                                        9, 6, 5, 3, 2, 0, 1, 7, 8,
                                                                        3, 4, 1, 6, 8, 9, 7, 5, 2,
                                                                        5, 9, 3, 4, 6, 8, 2, 0, 1,
                                                                        4, 7, 2, 5, 1, 3, 6, 8, 9,
                                                                        6, 1, 8, 9, 7, 2, 4, 3, 5,
                                                                        7, 8, 6, 2, 3, 5, 9, 1, 4,
                                                                        1, 5, 4, 7, 9, 6, 8, 2, 3,
                                                                        2, 3, 9, 8, 4, 1, 5, 6, 7));
        List<Integer> incompleteValues = new ArrayList<>(Arrays.asList(0, 2, 7, 1, 5, 4, 3, 0, 6,
                                                                       9, 6, 5, 3, 2, 7, 1, 4, 8,
                                                                       3, 4, 1, 6, 8, 9, 7, 0, 2,
                                                                       5, 0, 3, 4, 6, 8, 2, 7, 1,
                                                                       4, 7, 2, 5, 1, 3, 6, 8, 9,
                                                                       6, 1, 8, 9, 7, 2, 4, 3, 0,
                                                                       7, 8, 6, 2, 3, 5, 9, 1, 4,
                                                                       1, 5, 4, 7, 9, 0, 8, 2, 3,
                                                                       2, 3, 9, 0, 4, 1, 5, 6, 7));

        solvedPuzzle = new Puzzle(solvedValues);
        invalidRowPuzzle = new Puzzle(invalidRowValues);
        invalidColumnPuzzle = new Puzzle(invalidColumnValues);
        invalidGridPuzzle = new Puzzle(invalidGridValues);
        incompletePuzzle = new Puzzle(incompleteValues);
    }

    @Test
    public void testConstructor() {
        List<Integer> firstRow = new ArrayList<>(Arrays.asList(8, 2, 7, 1, 5, 4, 3, 9, 6));
        List<Integer> finalRow = new ArrayList<>(Arrays.asList(2, 3, 9, 8, 4, 1, 5, 6, 7));
        List<Integer> firstColumn = new ArrayList<>(Arrays.asList(8, 9, 3, 5, 4, 6, 7, 1));
        List<Integer> finalColumn = new ArrayList<>(Arrays.asList(6, 8, 2, 1, 9, 5, 4, 3, 7));
        List<Integer> firstGrid = new ArrayList<>(Arrays.asList(8, 2, 7, 9, 6, 5, 3, 4, 1));
        List<Integer> centerGrid = new ArrayList<>(Arrays.asList(4, 6, 8, 5, 1, 3, 9, 7, 2));
        List<Integer> finalGrid = new ArrayList<>(Arrays.asList(9, 1, 4, 8, 2, 3, 5, 6, 7));
        assertTrue(equalLists(solvedPuzzle.getRows().get(0).getSquares(), firstRow));
        assertTrue(equalLists(solvedPuzzle.getRows().get(8).getSquares(), finalRow));
        assertTrue(equalLists(solvedPuzzle.getColumns().get(0).getSquares(), firstColumn));
        assertTrue(equalLists(solvedPuzzle.getColumns().get(8).getSquares(), finalColumn));
        assertTrue(equalLists(solvedPuzzle.getGrids().get(0).getSquares(), firstGrid));
        assertTrue(equalLists(solvedPuzzle.getGrids().get(4).getSquares(), centerGrid));
        assertTrue(equalLists(solvedPuzzle.getGrids().get(8).getSquares(), finalGrid));
    }

    @Test
    public void testisSolved() {
        assertTrue(solvedPuzzle.isSolved());
    }

    @Test
    public void testUnsolvedInvalid() {
        assertFalse(invalidGridPuzzle.isSolved());
        assertFalse(invalidRowPuzzle.isSolved());
        assertFalse(invalidColumnPuzzle.isSolved());
    }

    @Test
    public void testUnsolvedNotCompleted() {
        assertFalse(incompletePuzzle.isSolved());
    }

    @Test
    public void testisValid() {
        assertTrue(solvedPuzzle.isValid());
        assertTrue(incompletePuzzle.isValid());
    }

    @Test
    public void testisInvalid() {
        assertFalse(invalidRowPuzzle.isValid());
        assertFalse(invalidColumnPuzzle.isValid());
        assertFalse(invalidGridPuzzle.isValid());
    }

    @Test
    public void testGetValues() {

    }

    public boolean equalLists(List<Square> actual, List<Integer> expected) {
        for (int i = 0; i < 8; i++) {
            if (actual.get(i).getValue() != expected.get(i)) {
                return false;
            }
        }
        return true;
    }
}
