/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;
//import csci152.impl.ArrayQueue;
//import csci152.impl.ArrayStack;
//import csci152.impl.MethodsLesson8;

/**
 *
 * @author Master
 */
public class MethodsLesson9 {

    public static int evenCount(Stack<Integer> stk) throws Exception {
        int count = 0;
        Stack<Integer> temp = new ArrayStack();
        int size = stk.getSize();

        for (int i = 0; i < size; i++) {
            int element;
            element = stk.pop();
            if (element % 2 == 0) {
                count++;
            }
            temp.push(element);
        }

        for (int i = 0; i < size; i++) {
            stk.push(temp.pop());
        }

        return count;
    }

    public static Stack<Integer> copyStack(Stack<Integer> orig) throws Exception {
        Stack<Integer> temp = new ArrayStack();
        int size = orig.getSize();

        for (int i = 0; i < size; i++) {
            int element;
            element = orig.pop();
            temp.push(element);
        }

        for (int i = 0; i < size; i++) {
            orig.push(temp.pop());
        }
        return orig;
    }

    public static void insert(Stack<Integer> st, int pos, int val) throws Exception {
        Stack<Integer> temp = new ArrayStack();
        int size = st.getSize();

        int place = (size - pos);
        for (int i = 0; i <= place; i++) {
            temp.push(st.pop());
        }
        st.push(val);
        for (int i = 0; i <= place; i++) {
            st.push(temp.pop());
        }
    }

    public static boolean isPalindrome(Queue<Integer> q) throws Exception {
        Stack<Integer> stack = new ArrayStack();
        Queue<Integer> queue = new ArrayQueue();
        int size = q.getSize();
        for (int i = 0; i < size; i++) {
            int element = q.dequeue();
            stack.push(element);
            queue.enqueue(element);
        }
        while (stack.getSize() != 0) {
            if (stack.pop() != queue.dequeue()) return false;
        }
        return true;
    }
}
