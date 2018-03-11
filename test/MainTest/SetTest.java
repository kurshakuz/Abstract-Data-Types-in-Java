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
public class SetTest {

    public static void main(String[] args) {

        Set<Integer> numbers = new LLQueueSet();

        numbers.add(11);
        numbers.add(55);
        numbers.add(32);
        System.out.println(numbers);
        
        numbers.add(55);
        System.out.println(numbers);
               
        Set<String> names = new LLQueueSet();
        
        names.add("Marty");
        names.add("June");
        names.add("Alice");
        System.out.println(names);

        names.add("Marty");
        System.out.println(names);
    }
}
