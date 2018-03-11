/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Stack;

/**
 *
 * @author Master
 */
public class isPalindrome {
    
    public static boolean isPalindrome(Queue<Character> q) throws Exception {
        Stack<Character> stack = new LinkedListStack();
        Queue<Character> queue = new LinkedListQueue();
        Queue<Character> temp = new LinkedListQueue();
        int size = q.getSize();
        for (int i = 0; i < size; i++) {
            char element = q.dequeue();
            stack.push(element);
            queue.enqueue(element);
            temp.enqueue(element);
        }
        while (stack.getSize() != 0) {
            q.enqueue(temp.dequeue());
            if (stack.pop() != queue.dequeue()) return false;
        }
        return true;
    }

}
