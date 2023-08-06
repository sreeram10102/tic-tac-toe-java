package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class MakerTest {
    MarkInterface check1;
    MarkInterface check2;
    MarkInterface check3;
    MarkInterface check4;
    MarkInterface check5;
    MarkInterface check7;
    MarkInterface check8;
    MarkInterface check9;
    MarkInterface setfirst;
    MarkInterface check11;
    MarkInterface check33;

    MarkInterface check67;
    MarkInterface array[];

    @Before
    public void setter() {
        setfirst = UTTTFactory.createMark(Symbol.EMPTY, 0);
        check9 = UTTTFactory.createMark(Symbol.EMPTY, 1);
        check1 = UTTTFactory.createMark(Symbol.CROSS, 2);
        check2 = UTTTFactory.createMark(Symbol.CIRCLE, 3);
        check3 = UTTTFactory.createMark(Symbol.EMPTY, 4);
        check4 = UTTTFactory.createMark(Symbol.CROSS, 5);
        check5 = UTTTFactory.createMark(Symbol.CROSS, 6);
        check7 = UTTTFactory.createMark(Symbol.CIRCLE, 7);
        check8 = UTTTFactory.createMark(Symbol.CROSS, 8);

        check33 = UTTTFactory.createMark(Symbol.CROSS, 8);
        // MarkInterface[] array = new MarkInterface[4];

    }

    @Test
    public void getter1() {
        assertNotNull(check3);
        assertNotNull(check1);
        assertNotNull(check2);
        assertNotNull(setfirst);
        assertNotNull(check9);
        assertNotNull(check1);
        assertNotNull(check2);
        assertNotNull(check3);
        assertNotNull(check4);
        assertNotNull(check5);
        assertNotNull(check7);
        assertNotNull(check8);
        assertNull(check33.getSymbol());
        assertEquals(Symbol.EMPTY, check3.getSymbol());
        assertEquals(Symbol.CROSS, check1.getSymbol());
        assertEquals(Symbol.CIRCLE, check2.getSymbol());
        assertEquals(0, setfirst.getPosition());
        assertEquals(1, check9.getPosition());
        assertEquals(2, check1.getPosition());
        assertEquals(3, check2.getPosition());

        assertEquals(4, check3.getPosition());
        assertEquals(5, check4.getPosition());
        assertEquals(6, check5.getPosition());
        assertEquals(7, check7.getPosition());
        assertEquals(8, check8.getPosition());

    }

    @Test
    public void player67() {
        assertThrows(IllegalArgumentException.class, () -> {
            check33.setSymbol(null);
        });
    }

    @Test
    public void gettretpositiob() {
        MarkInterface array[] = new MarkInterface[4];
        array[3] = UTTTFactory.createMark(Symbol.CROSS, 3);
        assertEquals(3, array[3].getPosition());
    }

}
