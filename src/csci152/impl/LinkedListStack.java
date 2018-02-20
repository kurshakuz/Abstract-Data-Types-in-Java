/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Master
 */
public class LinkedListStack<T> implements Stack<T> {

    private Node<T> top;
    private int size;

    public LinkedListStack() {
        top = new Node(null);
        size = 0;
    }

    @Override
    public void push(T value) {
        Node New = new Node(value);
        if (size==0) {
            top.setLink(New);
            size++;
            return;
        }
        size++;
        Node last = top.getLink();
        top.setLink(New);
        top.getLink().setLink(last);
    }

    @Override
    public T pop() throws Exception {
        if (size==0) {
            throw new Exception("List is empty");
        } 
        if (size==1) {
            size = 0;
            T value = top.getLink().getValue();
            top.setLink(null);
            return value;
        }
        size--;
        T value = top.getLink().getValue();
        top.getLink().setValue(null);
        Node prev = top.getLink().getLink();
        top.getLink().setLink(null);
        top.setLink(prev);
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
                pop();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    @Override
    public String toString() {
        String message = "top [";
        Node m = top.getLink();
        int i = 0;
        while (i < size) {
            message += m.getValue()+" ";
            m = m.getLink();
            i++;
        }
        message += "] bottom";
        return message;
    }
}
