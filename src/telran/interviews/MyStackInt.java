package telran.interviews;

import java.util.EmptyStackException;
import java.util.LinkedList;

// All methods should have complexity O(1)
public class MyStackInt {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> maxStackElements = new LinkedList<>();

    public void push(int num) {
        stack.add(num);
        if (maxStackElements.isEmpty() || num >= maxStackElements.getLast()) {
            maxStackElements.add(num);
        }
    }

    public int pop() {
        checkForException();
        int res = stack.removeLast();
        if (res == maxStackElements.getLast()) {
            maxStackElements.removeLast();
        }
        return res;
    }

    public int peek() {
        checkForException();
        return stack.getLast();
    }

    private void checkForException() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMaxElement() {
        checkForException();
        return maxStackElements.getLast();
    }
}
