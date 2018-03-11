/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.Set;
import static csci152.impl.isSubset.isSubset;

/**
 *
 * @author Master
 */
public class union {

    public static Set<String> union(Set<String> set1, Set<String> set2) throws Exception {
        Set<String> temp1 = new LLQueueSet();
        Set<String> temp2 = new LLQueueSet();
        Set<String> union = new LLQueueSet();

        while (set1.getSize() != 0) {
            temp1.add(set1.removeAny());
        }

        while (set2.getSize() != 0) {
            temp2.add(set2.removeAny());
        }

        while (temp1.getSize() != 0) {
            String x1 = temp1.removeAny();
            union.add(x1);
            set1.add(x1);
        }

        while (temp2.getSize() != 0) {
            String x2 = temp2.removeAny();
            union.add(x2);
            set2.add(x2);
        }
        return union;

    }

    public static void main(String[] args) throws Exception {
        Set<String> set1 = new LLQueueSet();
        Set<String> set2 = new LLQueueSet();

        set1.add("A");
        set1.add("B");
        set1.add("C");

        set2.add("D");
        set2.add("E");
        set2.add("B");
        set2.add("A");
        set2.add("S");

        System.out.println(union(set1, set2));
    }

}
