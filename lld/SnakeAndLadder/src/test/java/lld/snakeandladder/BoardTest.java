package lld.snakeandladder;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        // Initialize a board with 100 cells, 5 snakes, and 5 ladders
        board = new Board(100, 5, 5);
    }

    @Test
    void testCellCount() {
        assertEquals(101, board.cells.size()); // Cells are 0-indexed, so 100 cells + 1
    }

    @Test
    void testStartAndEndCells() {
        assertEquals(CellType.START, board.cells.get(0).getType());
        assertEquals(CellType.END, board.cells.get(100).getType());
    }

    @Test
    void testSnakePlacement() {
        boolean hasSnake = false;
        for (Cell cell : board.cells) {
            if (cell.getType() == CellType.SNAKE) {
                hasSnake = true;
                assertTrue(cell.getFinalPosition() < cell.getPosition()); // Snake head should be greater than tail
            }
        }
        assertTrue(hasSnake); // Ensure at least one snake is placed
    }

    @Test
    void testLadderPlacement() {
        boolean hasLadder = false;
        for (Cell cell : board.cells) {
            if (cell.getType() == CellType.LADDER) {
                hasLadder = true;
                assertTrue(cell.getFinalPosition() > cell.getPosition()); // Ladder start should be less than end
            }
        }
        assertTrue(hasLadder); // Ensure at least one ladder is placed
    }

    @Test
    void testGetNextPosition() {
        // Test normal cell
        assertEquals(10, board.getNextPosition(10));

        // Test snake cell
        Cell snakeCell = board.cells.stream()
                .filter(cell -> cell.getType() == CellType.SNAKE)
                .findFirst()
                .orElse(null);
        assertNotNull(snakeCell);
        assertEquals(snakeCell.getFinalPosition(), board.getNextPosition(snakeCell.getPosition()));

        // Test ladder cell
        Cell ladderCell = board.cells.stream()
                .filter(cell -> cell.getType() == CellType.LADDER)
                .findFirst()
                .orElse(null);
        assertNotNull(ladderCell);
        assertEquals(ladderCell.getFinalPosition(), board.getNextPosition(ladderCell.getPosition()));
    }
}
