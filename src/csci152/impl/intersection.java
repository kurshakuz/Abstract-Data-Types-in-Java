/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;

/**
 *
 * @author Master
 */
public class intersection {
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) throws Exception {
        Set<Integer> temp1 = new LLQueueSet();
        Set<Integer> temp2 = new LLQueueSet();
        Set<Integer> intersection = new LLQueueSet();

        while (set1.getSize() != 0) {
            temp1.add(set1.removeAny());
        }

        while (set2.getSize() != 0) {
            temp2.add(set2.removeAny());
        }

        while (temp1.getSize() != 0) {
            int x = temp1.removeAny();
            if (temp2.contains(x)) {
                intersection.add(x);
            }
            set1.add(x);
        }
        
        while (temp2.getSize() != 0) {
            int x = temp2.removeAny();
            if (temp1.contains(x)) {
                intersection.add(x);
            }
            set2.add(x);
        }
        
        return intersection;
        
    }

    public static void main(String[] args) throws Exception {
        Set<Integer> set1 = new LLQueueSet();
        Set<Integer> set2 = new LLQueueSet();
        
        set1.add(2);
        set1.add(1);
        set1.add(25);
        
        set2.add(1);
        set2.add(2);
        set2.add(25);
        set2.add(6);
        set2.add(33);
        
        System.out.println(intersection(set1, set2));
    }

}
