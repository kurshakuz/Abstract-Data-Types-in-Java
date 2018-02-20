/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.ArrayQueue;
import csci152.impl.ArrayStack;
//import csci152.impl.MethodsLesson8;
import static csci152.impl.MethodsLesson9.copyStack;
import static csci152.impl.MethodsLesson9.evenCount;
import static csci152.impl.MethodsLesson9.insert;
import static csci152.impl.MethodsLesson9.isPalindrome;

/**
 *
 * @author Master
 */
public class TestMethodsLesson9 {

    public static void main(String[] args) throws Exception {

        Stack<Integer> stack = new ArrayStack();
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(8);

        Stack<Integer> copyofstack = new ArrayStack();

        copyofstack = copyStack(stack);
        System.out.println(evenCount(stack));

        System.out.println(copyofstack);

        //Checking insert func
        stack.push(7);
        stack.push(12);
        System.out.println(stack);
        insert(stack, 2, 6);
        System.out.println(stack);
        //

        Queue<Integer> queue = new ArrayQueue();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        System.out.println(isPalindrome(queue));
    }
}
