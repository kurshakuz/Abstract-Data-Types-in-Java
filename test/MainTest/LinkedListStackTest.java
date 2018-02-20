/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Stack;
import csci152.impl.LinkedListStack;
import static csci152.impl.isIncreasing.isIncreasing;

/**
 *
 * @author Master
 */
public class LinkedListStackTest {
    public static void main(String[] args) {

        Stack<Double> stack = new LinkedListStack();

        try {
            stack.pop();
        } catch (Exception Ex) {
        }

        for (double i = 0; i < 12; i++) {
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
        
        for (double i = 0; i < 22; i++) {
            stack.push(i);
        }
        
        System.out.println(stack);

        
        System.out.println(isIncreasing(stack));
        
    }
       
}