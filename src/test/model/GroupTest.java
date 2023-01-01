package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {
    private Group validGroup;
    private Group invalidGroup1;
    private Group invalidGroup2;


    @BeforeEach
    public void setup() {
        Square emptySquare = new Square(0);
        Square square1 = new Square(1);
        Square square5 = new Square(5);
        Square square9 = new Square(9);
        List<Square> validSquares = new ArrayList<>();
        List<Square> invalidSquares1 = new ArrayList<>();
        List<Square> invalidSquares2 = new ArrayList<>();
        validSquares.add(square1);
        validSquares.add(emptySquare);
        validSquares.add(emptySquare);
        validSquares.add(emptySquare);
        validSquares.add(square5);
        validSquares.add(emptySquare);
        validSquares.add(emptySquare);
        validSquares.add(emptySquare);
        validSquares.add(square9);
        invalidSquares1.add(square1);
        invalidSquares1.add(emptySquare);
        invalidSquares1.add(emptySquare);
        invalidSquares1.add(emptySquare);
        invalidSquares1.add(square5);
        invalidSquares1.add(emptySquare);
        invalidSquares1.add(emptySquare);
        invalidSquares1.add(square9);
        invalidSquares1.add(square9);
        invalidSquares2.add(square1);
        invalidSquares2.add(emptySquare);
        invalidSquares2.add(emptySquare);
        invalidSquares2.add(emptySquare);
        invalidSquares2.add(square5);
        invalidSquares2.add(emptySquare);
        invalidSquares2.add(emptySquare);
        invalidSquares2.add(square1);
        invalidSquares2.add(square9);
        validGroup = new Group(validSquares);
        invalidGroup1 = new Group(invalidSquares1);
        invalidGroup2 = new Group(invalidSquares2);

    }

    @Test
    public void testConstructor() {
        assertEquals(1, validGroup.getSquares().get(0).getValue());
        assertEquals(0, validGroup.getSquares().get(1).getValue());
        assertEquals(5, validGroup.getSquares().get(4).getValue());
        assertEquals(9, validGroup.getSquares().get(8).getValue());
    }

    @Test
    public void testIsValid() {
        assertTrue(validGroup.isValid());
        assertFalse(invalidGroup1.isValid());
        assertFalse(invalidGroup2.isValid());
        assertEquals(9, validGroup.getSquares().size());
    }
}
