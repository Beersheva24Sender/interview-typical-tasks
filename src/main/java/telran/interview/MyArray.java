package telran.interview;

import java.util.Arrays;

public class MyArray<T> {
    private final Object[] array; 
    private final int size; 

    public MyArray(int size) {
        this.size = size;
        this.array = new Object[size]; 
    }

    public void setAll(T value) {
        Arrays.fill(array, value); 
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        array[index] = value; 
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return (T) array[index]; 
    }
}

