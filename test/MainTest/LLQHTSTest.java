package MainTest;

import csci152.adt.HashTableSet;
import csci152.adt.Set;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;

public class LLQHTSTest {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new LLQHashTableSet<>(10);

        try {
            set.removeAny();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        for (int i = 0; i < 21; i++) {
            set.add(i);
        }
        System.out.println(set);

        for (int i = 0; i < 21; i = i + 2) {
            set.remove(i);
        }
        System.out.println(set);

        System.out.println(set.remove(10));
        System.out.println(set.remove(100));


        for (int i = 0; i < 31; i++) {
            set.add(i);
        }
        System.out.println(set);

        for (int i = 0; i < 10; i++) {
            System.out.println(set.removeAny());
        }
        System.out.println(set);

        set.clear();
        System.out.println(set);

        for (int i = 53; i < 80; i = i + 2) {
            set.add(i);
        }
        System.out.println(set);



        System.out.println("\n\n\n");

        HashTableSet<Integer> setTest = new LLQHashTableSet(2);
        setTest.add(2);
        setTest.add(3);
        setTest.add(13);
        setTest.add(23);
        //setTest.add(33);
        //setTest.add(43);
        System.out.println(setTest);

        System.out.println(setTest.getBucketSizeStandardDev());
    }
}
