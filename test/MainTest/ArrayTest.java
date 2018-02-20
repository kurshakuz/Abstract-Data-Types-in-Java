/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Stack;
import csci152.impl.ArrayStack;

/**
 *
 * @author Master
 */
public class ArrayTest {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack();

        try {
            stack.pop();
        } catch (Exception Ex) {
        }

        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception Ex) {
        }

        System.out.println(stack);

        stack.clear();
        System.out.println(stack);
        
        for (int i = 0; i < 22; i++) {
            stack.push(i);
        }
        
        System.out.println(stack);

    }
}
