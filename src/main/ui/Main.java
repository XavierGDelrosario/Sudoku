package ui;

import model.Puzzle;
import model.Scraper;

public class Main {

    public static void main(String[] args) {
        Scraper scraper = new Scraper();
        Puzzle puzzle = scraper.createPuzzle();
        new SudokuGUI();
    }
}
