/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.SortedQueue;

/**
 *
 * @author Master
 * @param <T>
 */
public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private Node<T> front;
    private int size;

    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {
        Node<T> newNode = new Node(value);
        if (size == 0) {
            front = newNode;
            size++;
        } else {
            if (value.compareTo(front.getValue()) <= 0) {
                newNode.setLink(front);
                front = newNode;
                size++;
            } else {
                Node<T> now = front;
                Node<T> prev = null;
                while (now != null) {
                    if (value.compareTo(now.getValue()) <= 0) {
                        newNode.setLink(now);
                        prev.setLink(newNode);
                        break;
                    }
                    prev = now;
                    now = now.getLink();
                }
                size++;
                
                if (now == null) {
                    prev.setLink(newNode);
                }
            }
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        }
        T result = front.getValue();
        if (size == 1) {
            front = null;
            size = 0;
        } else {
            size--;
            front = front.getLink();
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        while (size > 0) {
            try {
                dequeue();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        String message = "front [";
        Node<T> m = front;
        while (m != null) {
            message += m.getValue() + " ";
            m = m.getLink();
        }
        return message += "] back";
    }

}
