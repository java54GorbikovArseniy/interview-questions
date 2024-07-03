package telran.interviews.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.MyStackInt;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MyStackIntTest {
    MyStackInt myStackInt;

    @BeforeEach
    void setUp() {
        myStackInt = new MyStackInt();
        myStackInt.push(7);
        myStackInt.push(9);
        myStackInt.push(19);
        myStackInt.push(16);
        myStackInt.push(5);
        myStackInt.push(20);

    }

    @Test
    void popTest() {
        assertEquals(20, myStackInt.pop());
        assertEquals(5, myStackInt.pop());
        assertEquals(16, myStackInt.pop());
        assertEquals(19, myStackInt.pop());
        assertEquals(9, myStackInt.pop());
        assertEquals(7, myStackInt.pop());
        assertThrowsExactly(EmptyStackException.class, () -> myStackInt.pop());
    }

    @Test
    void peekTest() {
        assertEquals(20, myStackInt.peek());
        myStackInt.pop();
        assertEquals(5, myStackInt.peek());

    }

    @Test
    void isEmptyTest() {
        assertFalse(myStackInt.isEmpty());
        popTest();
        assertTrue(myStackInt.isEmpty());
    }

    @Test
    void getMaxElementTest() {
        assertEquals(20, myStackInt.getMaxElement());
        myStackInt.pop();
        assertEquals(19, myStackInt.getMaxElement());
    }
}