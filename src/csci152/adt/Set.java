
package csci152.adt;

/**
 * A generic set
 * @param <T>
 */
public interface Set<T> {
    
    /**
     * Adds the given element to the set, if another 
     * element with the same value is not already there
     * 
     * @param value element to be added to the set
     */
    public void add(T value);

    /**
     * Returns whether or not an element with the same 
     * value is in the set
     * 
     * @param value that is checked for in the set
     * @return whether or not the value is contained in 
     *         the set
     */
    public boolean contains(T value);
    
    /**
     * Removes an element with the given value from the 
     * set and returns true, if it is there; otherwise, 
     * the set remains unchanged and false is returned
     * 
     * @param value to be removed from the set
     * @return whether or not the value is contained in 
     *         the set
     */
    public boolean remove(T value);
        
    /**
     * Removes some element from the set, and returns it,
     * if the set is not empty; if the set is empty, an 
     * exception is thrown
     * 
     * @return some element from the set
     * @throws Exception if the set is empty
     */
    public T removeAny() throws Exception;
    
    /**
     * @return the number of elements in the set
     */
    public int getSize();
    
    /**
     * Removes all elements from the set
     */
    public void clear();
       
    /**
     * @return a String representation of the set
     */
    @Override
    public String toString();
}
