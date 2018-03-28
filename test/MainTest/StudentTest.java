package MainTest;

import csci152.Student;
import csci152.adt.HashTableSet;
import csci152.adt.Set;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;

public class StudentTest {
    public static void main(String[] args) {
        HashTableSet<Student> students = new LLQHashTableSet<>(10);
        //LLQHashTableSet

        for (int i = 100; i < 300; i++) {
            Student studentTemp = new Student("Bob", i);
            students.add(studentTemp);
        }

        System.out.println(students);

        System.out.println(students.getLoadFactor());
        System.out.println(students.getBucketSizeStandardDev());
    }
}
