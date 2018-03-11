
package csci152.adt;

/**
 *
 * A generic double-ended queue
 * @param <T>
 */
public interface Deque<T> {
    
    /**
     * Adds an element to the front of the deque.
     * 
     * @param value element to be added
     */
    public void pushToFront(T value);
    
    /**
     * Adds an element to the end of the deque.
     * 
     * @param value element to be added
     */
    public void pushToBack(T value);
    
    /**
     * Removes and returns the front most element of the deque
     * 
     * @return the front most element of the deque
     * @throws Exception if the deque is empty
     */
    public T popFromFront() throws Exception;
    
    /**
     * Removes and returns the last element of the deque
     * 
     * @return the last element of the deque
     * @throws Exception if the deque is empty
     */
    public T popFromBack() throws Exception;
    
    /**
     * @return the size of the deque
     */
    public int getSize();
    
    /**
     * Removes all elements from the deque
     */
    public void clear();
    
    /**
     * @return a String representation of the deque
     */
    @Override
    public String toString();
}
