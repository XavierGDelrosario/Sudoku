package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    public Square nullSquare;
    public Square square;

    @BeforeEach
    public void setup() {
        nullSquare = new Square(0);
        square = new Square(1);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, nullSquare.getValue());
        assertEquals(1, square.getValue());
        assertTrue(nullSquare.isChangeable());
        assertFalse(square.isChangeable());
    }

    @Test
    public void testChangeable() {
        assertTrue(nullSquare.setValue(3));
        assertEquals(3, nullSquare.getValue());
    }

    @Test
    public void testUnchangeable() {
        assertFalse(square.setValue(3));
        assertEquals(1, square.getValue());
    }

}
