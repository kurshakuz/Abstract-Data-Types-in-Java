package MainTest;

import csci152.Student;
import csci152.adt.Set;
import csci152.impl.BSTSet;

public class BSTSetTest {

    public static void main(String[] args) throws Exception {
        Set<Integer> set = new BSTSet();

        set.add(5);
        set.add(12);
        set.add(3);
        set.add(6);
        set.add(14);
        set.add(2);
        set.add(-6);
        set.add(8);
        set.add(0);
        System.out.println(set);

        set.add(14);
        set.add(-6);
        set.add(5);
        System.out.println(set);

        System.out.println(set.contains(12));
        System.out.println(set.contains(7));
        System.out.println(set.contains(2));
        System.out.println(set.contains(-8));
        System.out.println(set.contains(5));

//        
//        Remove the integers 0, 6, and 3 in that order, and print the set’s contents and size afterwards
//Add the integers 6, 13, 99 and 11 to the set in that order, and print its contents and size
//Remove the integer 12 from the set, and print the set’s contents and size
//Remove the integer 5 from the set (the root!), and print the set’s contents and size
//Call removeAny three times, and print the set’s contents and size
//        
//        
        
        set.remove(0);
        set.remove(6);
        set.remove(3);
        System.out.println(set);
        
        set.add(6);
        set.add(13);
        set.add(99);
        set.add(11);
        System.out.println(set);
     
        set.remove(12);
        System.out.println(set);
        
        set.remove(5);
        System.out.println(set);
        
        set.removeAny();
        set.removeAny();
        set.removeAny();
        System.out.println(set);
        

        set.clear();
        System.out.println(set);

        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);
        
        set.clear();
        
                
        
        Set<Student> students = new BSTSet();

        students.add(new Student("Vasya", 1111));
        students.add(new Student("Jane", 4444));
        students.add(new Student("Aiya", 9876));
        students.add(new Student("Kasym", 1234));
        students.add(new Student("Dimash", 1504));
        System.out.println(students);

        Student jane = new Student("Jane", 4444);
        System.out.println(students);

        Student saddam = new Student("Saddam", 1111);
        

        students.add(new Student("Aiya", 9876));
        students.add(new Student("Kasym", 1234));
        System.out.println(students);

        students.add(new Student("Vasilyi", 2222));
        students.add(new Student("Adil", 3333));
        students.add(new Student("Dibil", 7856));
        System.out.println(students);

        students.clear();
        System.out.println(students);
        
        students.add(new Student("Vasya", 1111));
        students.add(new Student("Jane", 4444));
        System.out.println(students);
        
    }

}
