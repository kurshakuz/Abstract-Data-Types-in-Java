/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Stack;

/**
 *
 * @author Master
 */
public class isIncreasing {
    
     public static boolean isIncreasing (Stack<Double> st) {
         
        Stack<Double> temp = new LinkedListStack();
        double num;
        boolean ans = true;
        try {
            int i=0;
            num = st.pop();
            temp.push(num);
            int size = st.getSize();
            while (i <= size) {
                double tempNum = st.pop();
                temp.push(tempNum);
                if (tempNum > num) {
                    ans = false;
                }
                num = tempNum;
                i++;
            }
            size = temp.getSize();
            for (int j = 0; j < size; j++) {
                st.push(temp.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
    
}
