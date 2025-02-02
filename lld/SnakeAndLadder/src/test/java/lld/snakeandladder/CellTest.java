package lld.snakeandladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(10); // Create a cell at position 10
    }

    @Test
    void testCellInitialization() {
        assertEquals(10, cell.position);
        assertEquals(CellType.NORMAL, cell.getType());
    }

    @Test
    void testSetType() {
        cell.setType(CellType.SNAKE);
        assertEquals(CellType.SNAKE, cell.getType());
    }

    @Test
    void testSetFinalPosition() {
        cell.setFinalPosition(5);
        cell.setType(CellType.SNAKE);
        assertEquals(5, cell.getFinalPosition());
    }

    @Test
    void testGetFinalPosition() {
        cell.setType(CellType.SNAKE);
        cell.setFinalPosition(5);
        assertEquals(5, cell.getFinalPosition());

        cell.setType(CellType.NORMAL);
        assertEquals(10, cell.getFinalPosition()); // For normal cells, final position should be the cell's position
    }
}
