package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class SimulatorTest {
    SimulatorInterface simul = UTTTFactory.createSimulator();
    BoardInterface[] getboard = simul.getBoards();
    Symbol Shivam;
    Symbol whatiget;
    MarkInterface rami;
    int mark1;

    @Before
    public void rem() {
        simul = UTTTFactory.createSimulator();
        getboard = simul.getBoards();
        rami = UTTTFactory.createMark(Symbol.CIRCLE, 3);
        ;

    }

    @Test
    public void vero() {
        assertEquals(9, getboard.length);

        for (int i = 0; i < 9; i++) {
            // getboard[i];
            assertTrue(i < 9 && i >= 0);
        }

    }

    @Test
    public void ved() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.setBoards(null);
        });
    }

    @Test
    public void pranjal() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.setCurrentPlayerSymbol(null);
        });
    }

    @Test
    public void setting() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.setMarkAt(null, -67, -89);
        });
    }

    @Test
    public void setting1() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.setIndexNextBoard(57);
        });
    }

    @Test
    public void setting3() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.isMovePossible(57);
        });
    }

    @Test
    public void setting4() {
        assertThrows(IllegalArgumentException.class, () -> {
            simul.isMovePossible(57, 65);
        });
    }

    @Test

    public void tej() {
        for (int i = 0; i < 9; i++) {

            getboard[i] = UTTTFactory.createBoard();
        }

        BoardInterface[] ergebniss = simul.getBoards();
        assertTrue(Arrays.equals(getboard, ergebniss));

    }

    @Test
    public void maura() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        assertEquals(Symbol.CIRCLE, simul.getCurrentPlayerSymbol());

    }

    @Test
    public void next() {
        Symbol originalSymbol = simul.getCurrentPlayerSymbol();
        simul.setCurrentPlayerSymbol(rami.getSymbol());
        Symbol newSymbol = simul.getCurrentPlayerSymbol();

        assertEquals(rami.getSymbol(), newSymbol);
        assertNotEquals(originalSymbol, newSymbol);
    }

    @Test
    public void next3() {
        Symbol shivam = simul.getCurrentPlayerSymbol();
        assertTrue(simul.setMarkAt(shivam, 0, 3));
        assertEquals(3, simul.getIndexNextBoard());
        assertTrue(simul.getIndexNextBoard() >= 0);
        assertTrue(simul.getIndexNextBoard() < 9);

        Symbol anjali = simul.getCurrentPlayerSymbol();
        assertFalse(simul.setMarkAt(anjali, 0, 3));

    }

    @Test
    public void next10() {
        Symbol shivam = simul.getCurrentPlayerSymbol();
        simul.setIndexNextBoard(0);
        simul.setMarkAt(shivam, 0, 3);
        mark1 = 3;
        simul.setIndexNextBoard(mark1);
        assertTrue(mark1 == simul.getIndexNextBoard());
        simul.setIndexNextBoard(mark1);
        assertEquals(-1, simul.getIndexNextBoard());
    }

    @Test
    public void exceptionNextInex() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        Symbol shivam = simul.getCurrentPlayerSymbol();
        simul.setIndexNextBoard(0);
        simul.setMarkAt(shivam, 0, 3);
        for (int i = 0; i < 9; i++) {
            simul.setIndexNextBoard(3);
            simul.setMarkAt(Symbol.CIRCLE, 3, i);
        }
        simul.setIndexNextBoard(-1);

        assertEquals(-1, simul.getIndexNextBoard());

    }

    @Test
    public void next11() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 1);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 5);

        assertTrue(simul.isGameOver());
    }

    @Test
    public void next12() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 1);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 5);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertTrue(simul.isGameOver());
    }

    @Test
    public void next14() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertTrue(simul.isGameOver());
    }

    @Test
    public void next15() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertTrue(simul.isGameOver());
    }

    @Test
    public void next97() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertTrue(simul.isGameOver());
    }

    @Test
    public void next16() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                simul.setCurrentPlayerSymbol(Symbol.CROSS);
                simul.setIndexNextBoard(i);
                simul.setMarkAt(Symbol.CROSS, i, j);
            }
        }

        assertFalse(simul.isGameOver());
    }

    @Test
    public void next17() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        assertFalse(simul.isGameOver());
    }

    @Test
    public void next21() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);

        assertFalse(simul.isGameOver());
    }

    @Test
    public void next20() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(3);
        simul.setMarkAt(Symbol.CROSS, 3, 3);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 4);

        assertFalse(simul.isGameOver());
    }

    @Test
    public void next22() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j % 2 == 0) {
                    simul.setCurrentPlayerSymbol(Symbol.CROSS);
                    simul.setMarkAt(Symbol.CROSS, i, j);
                } else {
                    simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
                    simul.setMarkAt(Symbol.CIRCLE, i, j);
                }
            }
        }
    }

    @Test
    public void next23() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(3);
        simul.setMarkAt(Symbol.CROSS, 3, 5);

        for (int i = 0; i < 9; i++) {
            getboard[i] = UTTTFactory.createBoard();
            simul.setCurrentPlayerSymbol(Symbol.CROSS);
            simul.setIndexNextBoard(5);
            simul.setMarkAt(Symbol.CROSS, 5, i);
        }
        assertFalse(simul.isMovePossible(simul.getIndexNextBoard()));
    }

    @Test
    public void next24() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 8);
        simul.setMarkAt(Symbol.EMPTY, 8, 3);
        assertTrue(simul.isMovePossible(8));
    }

    @Test
    public void next27() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 8);

        simul.setMarkAt(Symbol.EMPTY, 8, 3);
        mark1 = 8;

        assertTrue(simul.isMovePossible(mark1, 3) == simul.isMovePossible(mark1));

    }

    @Test
    public void next28() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setMarkAt(Symbol.CROSS, 8, 3);
        mark1 = 8;

        assertFalse(simul.isMovePossible(mark1, 3) == simul.isMovePossible(mark1));

    }

    @Test
    public void next29() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 1);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 5);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertEquals(Symbol.CROSS, simul.getWinner());

    }

    @Test
    public void next30() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 1);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 4);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 2);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 5);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 8);

        assertEquals(Symbol.CIRCLE, simul.getWinner());

    }

    @Test
    public void next31() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 1);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 5);

        assertEquals(Symbol.CROSS, simul.getWinner());
    }

    @Test
    public void next32() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 1);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 2);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 3);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 5);

        assertEquals(Symbol.CIRCLE, simul.getWinner());
    }

    @Test
    public void next33() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertEquals(Symbol.CROSS, simul.getWinner());
    }

    @Test
    public void next34() {
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 3);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CIRCLE, 0, 6);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 7);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CIRCLE, 1, 8);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CIRCLE);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CIRCLE, 4, 8);

        assertEquals(Symbol.CIRCLE, simul.getWinner());
    }

    @Test
    public void next98() {
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(0);
        simul.setMarkAt(Symbol.CROSS, 0, 8);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 2);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(1);
        simul.setMarkAt(Symbol.CROSS, 1, 6);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 0);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 4);
        simul.setCurrentPlayerSymbol(Symbol.CROSS);
        simul.setIndexNextBoard(4);
        simul.setMarkAt(Symbol.CROSS, 4, 8);

        assertEquals(Symbol.CROSS, simul.getWinner());
    }

}
