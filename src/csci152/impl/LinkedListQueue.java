/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;


public class LinkedListQueue<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;
    private Node<T> link;
    int size;
    
    public LinkedListQueue() {
        front = new Node(null);
        back = new Node(null);
        link = new Node(null);
        size = 0;
    }
    
    @Override
    public void enqueue(T value) {
        Node New = new Node(value);

        if (size == 0) {
            back.setLink(New);
            front.setLink(New);
            size++;
        }
//        int i = 0;
//        while (i <= size) {
//            link.setLink(front.getLink());
//        }
        size++;
        back.getLink().setLink(New);
        back.setLink(New);
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception("Queue is empty");
        } 
        if (size == 1) {
            size = 0;
            T value = front.getLink().getValue();
            front.setLink(null);
            back.setLink(null);
            return value;
        }
        size--;
        T value= front.getLink().getValue();
        front.setLink(front.getLink().getLink());
        return value;
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
            message += m.getValue()+" ";
            m = m.getLink();
        }
        return message += "] back";
    }
    
}
