package MainTest;

import csci152.adt.Stack;
import csci152.impl.ArrayListStack;

public class ArrayListStackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayListStack<Integer>();

        try {
            stack.pop();
        } catch (Exception Ex) {
        }

        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }

        System.out.println(stack);

        try {
            System.out.println(stack.pop());
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
