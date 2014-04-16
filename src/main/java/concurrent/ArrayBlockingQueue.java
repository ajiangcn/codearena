package concurrent;

import java.util.List;

/**
 * Implementation of blocking queue
 */
public class ArrayBlockingQueue<E> {

    private final int capacity;
    private final Object[] data;
    private int start;
    private int end;
    private boolean isFull;


    ArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.start = 0;
        this.end = 0;
        this.isFull = false;
    }

    /**
     * Batch operation to insert a list of elements to the array
     * @return
     */
    public synchronized void add(List<E> elements) {
        for(E e : elements) {
            add(e);
        }
    }

    /**
     * Insert a single element to the array
     * @return
     */
    public synchronized void add(E element) {
        while(isFull) {
            try {
                wait();
            } catch(InterruptedException e) {
                // do nothing
            }
        }
        data[end] = element;
        end = (end + 1) % capacity;
        isFull = (end == start);
        notifyAll();
    }

    /**
     * Remove the item from the list
     */
    public synchronized E remove() {
        while(!isFull && (start==end)) {
            try {
                wait();
            } catch (InterruptedException e) {
                // do nothing;
            }
        }
        E result = (E)data[start];
        data[start] = null;
        start = (start + 1) % capacity;
        isFull = false;
        notifyAll();
        return result;
    }

}
