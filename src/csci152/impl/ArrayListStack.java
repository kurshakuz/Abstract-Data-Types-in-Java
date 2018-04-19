package csci152.impl;

import csci152.adt.Stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStack<T> implements Stack<T> {

    List<T> list = new ArrayList<T>();

    @Override
    public void push(T value) {
        list.add(value);
    }

    @Override
    public T pop() throws Exception {
        int x = list.size();
        if (x == 0) { throw new Exception("List is empty"); }

        return list.remove(x - 1);
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public String toString() {
        String m = "bottom [";
        for (int k = 0; k < getSize(); k++) {
            m += list.get(k) + " ";
        }
        m += "] top";
        //System.out.println("The size of stack is " + size);
        return m;
    }
}
