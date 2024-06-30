package telran.interviews;

import java.util.HashMap;

public class MyArray<T> {
    private int size;
    T defaultValue;
    HashMap<Integer, T> array = new HashMap<>(size);

    public void setAll(T value) {
        array = new HashMap<>(size);
        defaultValue = value;
    }

    public void set(int index, T value) {
        checkArrayIndex(index);
        array.put(index, value);
    }

    public T get(int index) {
        checkArrayIndex(index);
        return array.getOrDefault(index, defaultValue);
    }

    private void checkArrayIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public MyArray(int size) {
        if (size <= 0) {
            throw new NegativeArraySizeException();
        }
        this.size = size;
    }

}
