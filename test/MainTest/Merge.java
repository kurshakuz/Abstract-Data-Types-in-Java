/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Deque;
import csci152.impl.DoublyLinkedNode;
import csci152.impl.LinkedListDeque;

/**
 *
 * @author Master
 */
public class Merge {

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) throws Exception {

        Deque<Integer> deque = new LinkedListDeque<>();
        try {
            while (d1.getSize() > 0 && d2.getSize() > 0) {
                int d1Value = d1.popFromFront();
                int d2Value = d2.popFromFront();
                if (d1Value <= d2Value) {
                    deque.pushToBack(d1Value);
                    d2.pushToFront(d2Value);
                } else {
                    deque.pushToBack(d2Value);
                    d1.pushToFront(d1Value);
                }
            }
            while (d1.getSize() != 0) {
                int d1Value = d1.popFromFront();
                deque.pushToBack(d1Value);
            }
            while (d2.getSize() != 0) {
                int d2Value = d2.popFromFront();
                deque.pushToBack(d2Value);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return deque;
    }

    public static Deque<Integer> mergeSort(Deque<Integer> deq) throws Exception {
        int size = deq.getSize();
        if (size <= 1) {
            return deq;
        }
        
        Deque<Integer> firsthalf = new LinkedListDeque();
        Deque<Integer> secondhalf = new LinkedListDeque();
        for (int i = 0; i < size / 2; i++) {
            firsthalf.pushToBack(deq.popFromFront());
        }
        for (int i = 0; i < (size - size / 2); i++) {
            secondhalf.pushToBack(deq.popFromFront());
        }
        
        firsthalf = mergeSort(firsthalf);
        secondhalf = mergeSort(secondhalf);
        
        return deq = merge(firsthalf, secondhalf);
    }

    public static void main(String[] args) throws Exception {
        Deque<Integer> deque = new LinkedListDeque<>();
        for (int i = 0; i < 10; i++) {
            deque.pushToBack((int) (Math.random() * 50));
        }
        System.out.println("before:\n" + deque);
        System.out.println("after:\n" + mergeSort(deque));
    }

}
