/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Deque;
import csci152.impl.LinkedListDeque;

/**
 *
 * @author Master
 */
public class LinkedListDequeTest {

    public static void main(String[] args) throws Exception {

        Deque<Integer> deque = new LinkedListDeque();

        try {
            deque.popFromFront();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(deque);

        try {
            deque.popFromBack();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(deque);

        for (int i = 0; i < 5; i++) {
            deque.pushToFront(i);
            System.out.println(deque);
        }
        
        for (int i = 0; i < 5; i++) {
            deque.popFromFront();
            System.out.println(deque);
        }
        
        for (int i = 0; i < 6; i++) {
            deque.pushToFront(i);
            System.out.println(deque);
        }
        
        for (int i = 0; i < 6; i++) {
            deque.popFromBack();
            System.out.println(deque);
        }
        
        
        for (int i = 0; i < 7; i++) {
            deque.pushToBack(i);
            System.out.println(deque);
        }
        
        for (int i = 0; i < 7; i++) {
            deque.popFromBack();
            System.out.println(deque);
        }
        
        
        for (int i = 0; i < 8; i++) {
            deque.pushToBack(i);
            System.out.println(deque);
        }
        
        for (int i = 0; i < 8; i++) {
            deque.popFromFront();
            System.out.println(deque);
        }
        
        
        for (int i = 0; i < 10; i++) {
            deque.pushToBack(i);
            deque.pushToFront(i);
            System.out.println(deque);
        }
        
        for (int i = 0; i < 8; i++) {
            deque.popFromFront();
            deque.popFromBack();
            System.out.println(deque);
        }
        
        deque.clear();
        System.out.println(deque);
        
        deque.pushToFront(5);
        deque.pushToFront(2);

        deque.pushToBack(88);
        deque.popFromFront();

        System.out.println(deque);
    }
}
