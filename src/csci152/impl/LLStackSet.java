/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;
import csci152.adt.Stack;


/**
 *
 * @author Master
 */
public class LLStackSet<T> implements Set<T> {

    private Stack<T> stack = new LinkedListStack();
    
    public LLStackSet() {
        this.stack = new LinkedListStack<>();
    }

    @Override
    public void add(T value) {
        if (!(contains(value))) {
            stack.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int size = stack.getSize(); 
        Stack<T> stackTemp = new LinkedListStack();
        for (int i = 0; i < size; i++) {
            try {
                T x = stack.pop();
                stackTemp.push(x);

                if (x.equals(value)) {
                    int sizeTemp = stackTemp.getSize();
                    for (int j = 0; j < sizeTemp; j++) {
                        stack.push(stackTemp.pop());
                    }
                    return true;
                } else if (stack.getSize() == 0) {
                    int sizeTemp = stackTemp.getSize();
                    for (int j = 0; j < sizeTemp; j++) {
                        stack.push(stackTemp.pop());
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (contains(value)) {
            Stack<T> stackTemp = new LinkedListStack();
            T x = null;

            try {
                x = stack.pop();
            } catch (Exception ex) {
                System.out.println(ex);
            }

            while (!value.equals(x)) {
                stackTemp.push(x);
                try {
                    x = stack.pop();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }

            int size = stackTemp.getSize();
            for (int i = 0; i < size; i++) {
                try {
                    stack.push(stackTemp.pop());
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            
            return true;
        }
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        if (getSize() != 0) {
            T x = stack.pop();
            return x;
        } else {
            throw new Exception("set is empty");
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
//        String message = "{";
//        for (int i = 0; i < stack.getSize(); i++) {
//            try {
//                T x = stack.pop();
//                message += x + " ";
//                stack.push(x);
//            } catch (Exception ex) {
//                //OWubKA
//            }
//
//        }
//        message += "}";
//
//        return message += "\nSize: " + getSize();
        return stack.toString();

    }

}
