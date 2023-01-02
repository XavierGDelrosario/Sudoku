package ui;

import model.Group;
import model.Puzzle;
import model.Scraper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Represents a sudoku board
public class BoardUI extends JPanel {
     private final List<GridUI> grids;
     private final Scraper scraper;
     private Puzzle currentPuzzle;
    //EFFECTS: creates graphical representation of sudoku board
    public BoardUI() {
        grids = new ArrayList<>();

        setLayout(new GridLayout(3, 3, 0, 0));
        setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.BLACK));

        for (int i = 0; i < 9; i++) {
           GridUI gridUI = new GridUI();
           grids.add(gridUI);
           add(gridUI);
        }

        setVisible(true);
        scraper = new Scraper();
        drawBoard();
    }

    //EFFECTS: creates and adds each squareUI from given board to squares, display square in panel
    public void drawBoard(Puzzle puzzle) {
        currentPuzzle = puzzle;
        List<Group> groups = puzzle.getGrids();
        for (int i = 0; i < 9; i++) {
            grids.get(i).assignSquares(groups.get(i));
        }
        update();
    }

    //EFFECTS: uses scraper to draw a new board
    public void drawBoard() {
        scraper.createDocument();
        currentPuzzle = scraper.createPuzzle();
        List<Group> groups = currentPuzzle.getGrids();
        for (int i = 0; i < 9; i++) {
            grids.get(i).assignSquares(groups.get(i));
        }
        update();
    }

    //EFFECTS: updates all squares
    public void update() {
        for (GridUI grid : grids) {
            grid.update();
        }
    }

    public Puzzle getCurrentPuzzle() {
        return currentPuzzle;
    }
}

