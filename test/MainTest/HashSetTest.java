package MainTest;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) throws Exception {
//        Set<Integer> set = new BSTSet();
        Set<Integer> set = new HashSet<Integer>();

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

        set.clear();
        System.out.println(set);

        set.add(55);
        set.add(24);
        set.add(78);
        set.add(51);
        System.out.println(set);

        set.clear();

    }
}
