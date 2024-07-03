package telran.interviews.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreeSetTests {
    TreeSet<Integer> treeSet;
    Integer[] numbers  = {10, -20, 30, -100, 80, 35, 200};

    @BeforeEach
    void setUp(){
        treeSet = new TreeSet<>(List.of(numbers));
    }

    @Test
    void subsetTest(){
        Set<Integer> set = treeSet.subSet(10, false, 40, false);
        Integer[] expected = {30, 35};
        runTest(expected, set);
        Set<Integer> set1 = treeSet.subSet(10, true, 40, false);
        Integer[] expected1 = {30, 35, 10};
        runTest(expected1, set1);
    }

    @Test
    void subsetAsViewTest(){
        Set<Integer> set = treeSet.subSet(0, true, 50, false);
        set.add(20);
        Integer[] expected = {10, -20, 30, -100, 80, 35, 200, 20};
        runTest(expected, treeSet);
    }

    @Test
    void subsetAsViewRemoveTest(){
        Set<Integer> set = treeSet.subSet(0, true, 50, true);
        set.clear();
        Integer[] expected = {-20, -100, 80, 200};
        runTest(expected, treeSet);
    }

    void subSetAsCopyTest(){
//        Set<Integer> set = treeSet.subSet(0, true, 50, true);
            List<Integer> list = treeSet.stream().filter(n -> n >= 0 && n <= 50).
                    toList();
            TreeSet<Integer> set = new TreeSet<>(list);
            Integer[] expected = {10, 30, 35};
            runTest(expected, set);

    }
    private void runTest(Integer[] expected, Set<Integer> set){
        Arrays.sort(expected);
        Integer[] actual = set.toArray(Integer[]::new);
        assertArrayEquals(expected, actual);
    }
}
