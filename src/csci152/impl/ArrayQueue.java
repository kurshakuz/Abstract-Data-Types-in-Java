/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

/**
 *
 * @author Master
 */
import csci152.adt.Queue;

public class ArrayQueue<T> implements Queue<T> {
    private T[] values;
    private int size, front, back;
    
    public ArrayQueue(){
        values = (T[])new Object[5];
        size = 0;
        front = -1;
        back = -1;
    }
    @Override
    public void enqueue(T value){
        int nBack;
        if (back+1 == values.length) {
            if (front == 0) {
                T[] result = (T[])new Object[2*values.length];
                for (int i=0; i < values.length; i++) {
                    result[i] = values[i];
                }
                values = (T[])new Object[result.length];
                for (int i = 0; i < result.length; i++) {
                    values[i] = result[i];
                }
                nBack = (back + 1);
            } else {
                nBack = (back + 1) % values.length;
            }
        } else {
            nBack = back + 1;
        }
        values[nBack] = value;
        back = nBack;
        size++;
        
        if (front == -1) {
            front = 0;
        }
        
    }

    @Override
    public T dequeue() throws Exception {
        if (size == 0) throw new Exception("Queue is empty");
        T result = values[front];
        values[front] = null;
        size--;
        if (front == back) {
            this.clear();
            front = -1;
        } else {
            if ((front+1) < values.length) {
                front = front + 1;
            } else {
                front = 0;
            }
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = (T[])new Object[5];
        size = 0;
        front = -1;
        back = -1;
    }
    
    @Override
    public String toString(){        
        String result ="";
        int f = front;
        if (front == -1) return result;
        for(int i =0; i<size; i++) {
            result += String.valueOf(values[f])+ " ";
            f = (f+1<values.length) ? f+1 : 0;   
        }
        
        return result;
    }
    
}