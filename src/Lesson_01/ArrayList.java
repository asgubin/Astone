package Lesson_01;

public class ArrayList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private int capacity;
    private T[] array;

    public ArrayList() {
        this.array = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public void add(T value) {
        if ( (size + 1) >= capacity ) {
            resize();
        }

        array[size] = value;
        size++;
    }

    private void resize() {
        int newCapacity  = (capacity * 3) / 2 + 1;
        T[] newArray = (T[]) new Comparable[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        capacity = newCapacity;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (T) array[index];
    }


    public T remove(int index) {

        T oldValue = get(index);

        int numMoved = size - index - 1;
        System.arraycopy(array, index + 1, array, index, numMoved);

        array[size] = null;
        size--;

        return oldValue;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public T[] toArray() {
        return array;
    }
}