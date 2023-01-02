package model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Represents a webscraper for websudoku.com
public class Scraper {
    private Document doc;
    //EFFECTS: creates a scraper for sudoku website
    public Scraper () {
        createDocument();
    }

    //EFFECTS: returns puzzle from current link
    public Puzzle createPuzzle() {
        Elements cells = doc.select("td");
        List<Integer> values = new ArrayList<>();
        for (int i = 7; i < 88; i++) {
            if (cells.get(i).child(0).attributes().get("value").isBlank()) {
                values.add(0);
            } else {
                values.add(Integer.parseInt(cells.get(i).child(0).attributes().get("value")));
            }
        }

        return new Puzzle(values);
    }

    //MODIFIES: this
    //EFFECTS: connects to a new page from websudoku.com with a new puzzle
    public void createDocument() {
        try {
            doc = Jsoup.connect("https://four.websudoku.com/?").maxBodySize(0).get();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
