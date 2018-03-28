/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.Student;
import csci152.adt.Set;
import csci152.adt.Stack;

/**
 *
 * @author Master
 */
public class StackSet<T> implements Set<T> {

    Stack<T> stack = new LinkedListStack();

    @Override
    public void add(T value) {
        if (!(contains(value))) {
            stack.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < stack.getSize(); i++) {
            try {
                T x = stack.pop();
                stack.push(x);

                if (x.equals(value)) {
                    return true;
                }
            } catch (Exception ex) {
                //ablafk
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            for (int i = 0; i < stack.getSize(); i++) {
                try {
                    T x = stack.pop();
                    if (x != value) {
                        stack.push(x);
                    } else {
                        return true;
                    }
                } catch (Exception ex) {
                }
            }
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (getSize() != 0) {
            T x = stack.pop();
            return x;
        } else {
            throw new Exception ("set is empty");
        }
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public String toString() {
        String message = "{";
        for (int i = 0; i < stack.getSize(); i++) {
            try {
                T x = stack.pop();
                message += x + " ";
                stack.push(x);
            } catch (Exception ex) {
                //OWubKA
            }

        }
        message += "}";

        return message += "\nSize: " + getSize();

    }

}
