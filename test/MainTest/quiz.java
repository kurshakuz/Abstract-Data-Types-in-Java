/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.Set;
import csci152.impl.LLQueueSet;

/**
 *
 * @author Master
 */
public class quiz {

    public static void main(String[] args) {
        Set<Integer> s = new LLQueueSet();
        s.add(33);
        s.add(55);
        s.add(22);
        s.remove(55);
        s.add(-23);
        System.out.println(s);
    }

}
