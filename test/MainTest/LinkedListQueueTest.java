/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Queue;
import csci152.impl.LinkedListQueue;

/**
 *
 * @author Master
 */
public class LinkedListQueueTest {

    public static void main(String[] args) throws Exception {

        Queue<Integer> queue = new LinkedListQueue();
        try {
            queue.dequeue();
        } catch (Exception Ex) {
        }

        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
        }

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            queue.enqueue(i);
            queue.dequeue();
            queue.dequeue();
            System.out.println(queue);
        }
        
        queue.clear();
        System.out.println(queue);
        
        for (int i = 0; i < 23; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);
        
        try {
            queue.dequeue();
        } catch (Exception Ex) {
        }

    }
}
