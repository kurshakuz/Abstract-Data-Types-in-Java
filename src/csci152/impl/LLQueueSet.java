/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Master
 */
public class LLQueueSet<T> implements Set<T> {

    private Node<T> front;
    private Node<T> back;
    private Node<T> link;
    int size;

    public LLQueueSet() {
        front = null;
        back = null;
        link = new Node(null);
        size = 0;
    }

    @Override
    public void add(T value) {
        Node newNode = new Node(value);

        if (size == 0) {
            back = newNode;
            front = newNode;
            size++;
        } else {
            Node temp = front;
            while (temp.getLink() != null) {
                if (newNode.getValue() != temp.getValue()) {
                    temp = temp.getLink();
                } else {
                    return;
                }
            }
            size++;
            back.setLink(newNode);
            back = newNode;
        }
    }

    @Override
    public boolean contains(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(T value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeAny() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        String message = "{";
        Node<T> m = front;
        while (m != null) {
            message += m.getValue() + " ";
            m = m.getLink();
        }
        return message += "}";
    }

}
