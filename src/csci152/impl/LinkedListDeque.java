/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;

    private int size;

    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);
        if (size == 0) {
            front = node;
            back = node;
            size++;
            return;
        }
        size++;
        node.setNext(front);
        front.setPrevious(node);
        front = node;
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode node = new DoublyLinkedNode(value);
        if (size == 0) {
            front = node;
            back = node;
            size++;
            return;
        }
        size++;
        node.setPrevious(back);
        back.setNext(node);
        back = node;
    }

    @Override
    public T popFromFront() throws Exception {
        if (size == 0) {
            throw new Exception("Deque is empty");
        }
        if (size == 1) {
            size = 0;
            T value = front.getValue();
            front = null;
            back = null;
            return value;
        }
        size--;
        T value = front.getValue();
        front.getNext().setPrevious(null);
        front = front.getNext();

        return value;
    }

    @Override
    public T popFromBack() throws Exception {
        if (size == 0) {
            throw new Exception("Deque is empty");
        }
        if (size == 1) {
            size = 0;
            T value = front.getValue();
            front = null;
            back = null;
            return value;
        }
        size--;
        T value = back.getValue();
        back.getPrevious().setNext(null);
        back = back.getPrevious();
        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    public String toString() {
        String message = "front [";
        DoublyLinkedNode<T> m = front;
        while (m != null) {
            message += m.getValue() + " ";
            m = m.getNext();
        }
        message += "] back";
        return message += ("\nsize: " + size);
    }

}
