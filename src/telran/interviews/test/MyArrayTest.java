package telran.interviews.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.MyArray;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {

    MyArray<Integer> myArray = new MyArray<>(15);

    @BeforeEach
    void setUp() {
        myArray.set(0, 68);
        myArray.set(1, 96);
        myArray.set(2, 82);
        myArray.set(3, 37);
        myArray.set(10, 899);
    }

    @Test
    void setAllTest() {
        myArray.setAll(12);
        assertEquals(12, myArray.get(2));
        assertEquals(12, myArray.get(6));
        assertNotEquals(899, (int) myArray.get(10));
    }

    @Test
    void setTest() {
        myArray.set(4, 88);
        assertEquals(88, myArray.get(4));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> myArray.set(100, 99));
    }

    @Test
    void getTest() {
        assertEquals(899, myArray.get(10));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> myArray.get(100));
    }
}