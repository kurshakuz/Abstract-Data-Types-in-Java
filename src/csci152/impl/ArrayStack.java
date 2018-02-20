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
public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size, sizeMax = 10;

    public ArrayStack() {
        values = (T[])new Object[10];
        size = 0; 
    }

    
    @Override
    public void push(T value) {
        if (size+1 >= sizeMax) {
            sizeMax *= 2;
            T[] newValues = (T[])new Object[sizeMax];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }
        values[size] = value;
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (size==0) throw new Exception("This stack is empty!");
        else {
            T result = values[size - 1];
            size--;
        return result;
        }   
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[])new Object[10];
        size = 0;
        sizeMax = 10;
    }
    
    public String toString() {
        System.out.print("bottom [");
        for (int k = 0; k < size; k++) {
            System.out.print(values[k] + " ");
        }
        System.out.println("] top");
        System.out.println("The size of stack is " + size);
        return null;
    }
}
