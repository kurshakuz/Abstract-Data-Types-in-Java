/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.adt.SortedQueue;
import csci152.impl.LinkedListSortedQueue;
import csci152.Student;

/**
 *
 * @author Master
 */
public class LinkedListSortedQueueTest {

    public static void main(String[] args) throws Exception {

        SortedQueue<Integer> queue = new LinkedListSortedQueue();
        try {
            queue.dequeue();
        } catch (Exception Ex) {
        }

        for (int i = 9; i > 0; i--) {
            queue.insert(i * 10);
        }
        System.out.println(queue);
        System.out.println(queue.getSize());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getSize());

        for (int i = 1; i < 10; i++) {
            queue.insert(i * 100);
        }
        System.out.println(queue);
        System.out.println(queue.getSize());

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getSize());

        for (int i = 5; i <= 915; i += 10) {
            queue.insert(i);
        }
        System.out.println(queue);
        System.out.println(queue.getSize());

        while (queue.getSize() != 0) {
            queue.dequeue();
        }
        System.out.println(queue);
        System.out.println(queue.getSize());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        System.out.println(queue);
        System.out.println(queue.getSize());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.getSize());

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(3);
        System.out.println(queue);
        System.out.println(queue.getSize());

        SortedQueue<Student> students = new LinkedListSortedQueue();
        Student vasya = new Student(123, "Vasya");
        Student aiya = new Student(777, "Aiya");

        students.insert(aiya);
        students.insert(vasya);
        
        System.out.println(students);
        
        
    }
}
