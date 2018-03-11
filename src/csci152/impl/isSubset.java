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
public class isSubset {
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) throws Exception {
        Set<Integer> temp = new LLQueueSet();
        
        while (set1.getSize() != 0) {
            int x = set1.removeAny();
            temp.add(x);
        }
        
        while (temp.getSize() != 0) {
            int x = temp.removeAny();
            set1.add(x);
            if (!(set2.contains(x))) {
                return false;
            }
        }
        
        return true;
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
        
        System.out.println(isSubset(set1, set2));
        
    }
}
