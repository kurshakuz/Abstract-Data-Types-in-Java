/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainTest;

import csci152.Student;
import csci152.adt.Set;
import csci152.impl.LLStackSet;

/**
 *
 * @author Master
 */
public class LLStackSetTest {
    public static void main(String[] args) throws Exception {

        Set<Student> students = new LLStackSet();

        try {
            students.removeAny();
        } catch (Exception Ex) {
        }
        System.out.println(students);

        students.add(new Student("Vasya", 1111));
        students.add(new Student("Jane", 4444));
        students.add(new Student("Aiya", 9876));
        students.add(new Student("Kasym", 1234));
        students.add(new Student("Dimash", 1504));
        System.out.println(students);

        Student jane = new Student("Jane", 4444);
        students.remove(jane);
        System.out.println(students);

        Student saddam = new Student("Saddam", 1111);
        students.remove(saddam);
        System.out.println(students);

        students.add(new Student("Aiya", 9876));
        students.add(new Student("Kasym", 1234));
        System.out.println(students);

        students.add(new Student("Vasilyi", 2222));
        students.add(new Student("Adil", 3333));
        students.add(new Student("Dibil", 7856));
        System.out.println(students);

        System.out.println(students.removeAny());
        System.out.println(students.removeAny());
        System.out.println(students);
        
        students.clear();
        System.out.println(students);
        
        students.add(new Student("Vasya", 1111));
        students.add(new Student("Jane", 4444));
        System.out.println(students);
    }
}
