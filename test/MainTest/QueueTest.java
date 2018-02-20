/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Queue;
import csci152.impl.ArrayQueue;

/**
 *
 * @author Master
 */
public class QueueTest {
    
    public static void main(String[] args) throws Exception {
        
        Queue<Integer> iq = new ArrayQueue();
        
        iq.enqueue(22);
        iq.enqueue(66);
        iq.enqueue(35);
        iq.enqueue(7);
        System.out.println(iq);
        
        int val = iq.dequeue();
        System.out.println("Removed: " + val);
        System.out.println(iq);
    }
    
}
