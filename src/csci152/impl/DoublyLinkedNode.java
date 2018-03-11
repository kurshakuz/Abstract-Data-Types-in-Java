
package csci152.impl;

/**
 * Generic doubly-linked nodes
 * @param <T>
 */
public class DoublyLinkedNode<T> {
    
    private T value;
    
    private DoublyLinkedNode<T> previous;
    private DoublyLinkedNode<T> next;

    /**
     * Construct a doubly-linked node with the given value, 
     * and null previous and next links
     * 
     * @param val to set on the node
     */
    public DoublyLinkedNode(T val) {
        value = val;
        previous = null;
        next = null;
    }

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the previous
     */
    public DoublyLinkedNode<T> getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(DoublyLinkedNode<T> previous) {
        this.previous = previous;
    }

    /**
     * @return the next
     */
    public DoublyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    }
      
    /**
     * @return the string representation of the value 
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
