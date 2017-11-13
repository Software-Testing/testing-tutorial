package m2.vv.tutorial.collections;

import m2.vv.tutorial.collections.exceptions.StackOverflowException;
import m2.vv.tutorial.collections.exceptions.StackUnderflowException;

import java.lang.reflect.Array;

public class BoundedStack<T> {

    Class<T> type;

    private T[] buffer;

    private int count;

    public BoundedStack(Class<T> type) {
        this(type, 100);
    }

    public BoundedStack(Class<T> type, int capacity) {
        @SuppressWarnings("unchecked")
        final T[] buffer = (T[]) Array.newInstance(type, capacity);
        this.buffer = buffer;
        count = 0;
        this.type = type;
    }

    public int size() {
        return count;
    }

    public int capacity() { return buffer.length; }

    public void push(T item) throws StackOverflowException {
        if(count >= buffer.length)
            throw new StackOverflowException();
        buffer[count] = item;
        count++;
    }

    public void pushAll(T... items) throws StackOverflowException {
        if(size() + items.length > capacity())
            throw new StackOverflowException(String.format("Bounded stack with capacity %d can not accept %d elements", capacity(), size()));
        for(T it :items)
            push(it);
    }

    public T pop() throws StackUnderflowException {
        if(count <= 0)
            throw new StackUnderflowException();
        count--;
        return buffer[count];
    }

    public T[] popAll() {
        T[] result = (T[]) Array.newInstance(type, size());

        try {
            for(int i = 0; i < result.length; i++) {
                result[i] = pop();
            }
        }
        catch (StackUnderflowException exc) {
            throw new AssertionError("Underflow should not happen here", exc);
        }

        return result;
    }

    public T peek() throws StackUnderflowException {
        if(count <= 0)
            throw new StackUnderflowException();
        return buffer[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void clear() {
        for(int i=0; i< buffer.length; i++)
            buffer[i] = null;
        count = 0;
    }

}
