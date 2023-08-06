package uttt.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class CheckerTest {
    BoardInterface board;
    BoardInterface board1;
    BoardInterface board2;
    BoardInterface board3;
    MarkInterface user;
    BoardInterface userboy;

    @Before
    public void setUp() throws Exception {
        this.board = UTTTFactory.createBoard();
        userboy = UTTTFactory.createBoard();
        board1 = UTTTFactory.createBoard();

    }

    @Test
    public void amma() {
        MarkInterface[] markArray = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            markArray[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
        }
        board1.setMarks(markArray);

        MarkInterface[] result = board.getMarks();
        assertArrayEquals(markArray, result);
    }

    @Test
    public void ammu() {
        MarkInterface[] markArray = new MarkInterface[9];
        assertTrue(board.setMarkAt(Symbol.CROSS, 2));

        assertTrue(board.setMarkAt(Symbol.CIRCLE, 5));
        assertFalse(board.setMarkAt(Symbol.CROSS, 5));
        markArray = board.getMarks();
        for (int i = 0; i < 9; i++) {
            markArray[i].setSymbol(Symbol.CROSS);
            assertEquals(Symbol.CROSS, markArray[i].getSymbol());
            markArray[i].setSymbol(Symbol.CIRCLE);
            assertEquals(Symbol.CIRCLE, markArray[i].getSymbol());
        }
    }

    @Test

    public void play1() {
        MarkInterface[] markArray = new MarkInterface[9];

        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 1);
        userboy.setMarkAt(Symbol.CROSS, 2);
        assertTrue(userboy.isClosed());

        userboy.setMarkAt(Symbol.CIRCLE, 6);
        userboy.setMarkAt(Symbol.CIRCLE, 7);
        userboy.setMarkAt(Symbol.CIRCLE, 8);
        assertTrue(userboy.isClosed());
    }

    @Test
    public void play2() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 4);
        userboy.setMarkAt(Symbol.CROSS, 8);
        assertTrue(userboy.isClosed());

        userboy.setMarkAt(Symbol.CIRCLE, 2);
        userboy.setMarkAt(Symbol.CIRCLE, 4);
        userboy.setMarkAt(Symbol.CIRCLE, 6);
        assertTrue(userboy.isClosed());
    }

    @Test
    public void play10() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 3);
        userboy.setMarkAt(Symbol.CROSS, 6);
        assertTrue(userboy.isClosed());

        userboy.setMarkAt(Symbol.CIRCLE, 2);
        userboy.setMarkAt(Symbol.CIRCLE, 5);
        userboy.setMarkAt(Symbol.CIRCLE, 8);
        assertTrue(userboy.isClosed());
    }

    @Test
    public void play3() {
        BoardInterface userboy = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            userboy.setMarkAt(Symbol.CROSS, i);
        }
        assertTrue(userboy.isClosed());

    }

    @Test
    public void play4() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CIRCLE, 2);
        userboy.setMarkAt(Symbol.CIRCLE, 4);
        userboy.setMarkAt(Symbol.CIRCLE, 6);
        assertTrue(userboy.isClosed());
    }

    @Test
    public void play5() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.EMPTY, 4);

        assertTrue(userboy.isMovePossible(4));
    }

    @Test
    public void player56() {
        assertThrows(IllegalArgumentException.class, () -> {
            userboy.setMarks(null);
        });
    }

    @Test
    public void player57() {
        assertThrows(IllegalArgumentException.class, () -> {
            userboy.setMarkAt(null, 89);
        });
    }

    @Test
    public void player52() {
        assertThrows(IllegalArgumentException.class, () -> {
            userboy.isMovePossible(76);
        });
    }

    @Test
    public void play7() {
        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 1);
        userboy.setMarkAt(Symbol.CROSS, 2);
        assertEquals(Symbol.CROSS, userboy.getWinner());
    }

    @Test
    public void rajma3() {
        userboy.setMarkAt(Symbol.CIRCLE, 3);
        userboy.setMarkAt(Symbol.CIRCLE, 4);
        userboy.setMarkAt(Symbol.CIRCLE, 5);
        assertEquals(Symbol.CIRCLE, userboy.getWinner());
    }

    @Test
    public void play9() {
        BoardInterface userboy = UTTTFactory.createBoard();

        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 4);
        userboy.setMarkAt(Symbol.CROSS, 8);
        assertEquals(Symbol.CROSS, userboy.getWinner());
    }

    @Test
    public void rajma1() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CIRCLE, 2);
        userboy.setMarkAt(Symbol.CIRCLE, 4);
        userboy.setMarkAt(Symbol.CIRCLE, 6);
        assertEquals(Symbol.CIRCLE, userboy.getWinner());
    }

    @Test
    public void play11() {
        BoardInterface userboy = UTTTFactory.createBoard();
        userboy.setMarkAt(Symbol.CROSS, 0);
        userboy.setMarkAt(Symbol.CROSS, 3);
        userboy.setMarkAt(Symbol.CROSS, 6);
        assertEquals(Symbol.CROSS, userboy.getWinner());
    }

    @Test
    public void rajma2() {
        userboy.setMarkAt(Symbol.CIRCLE, 1);
        userboy.setMarkAt(Symbol.CIRCLE, 4);
        userboy.setMarkAt(Symbol.CIRCLE, 7);
        assertEquals(Symbol.CIRCLE, userboy.getWinner());
    }
}
