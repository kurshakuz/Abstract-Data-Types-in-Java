package MainTest;

import csci152.adt.HashTableSet;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;

import java.util.Random;

public class TimingTest2 {
    public static void main(String[] args) {

        HashTableSet<Integer> set = new BSTHashTableSet<>(5000);

        Random randomno = new Random();

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 50000; i++) {
            set.add(randomno.nextInt(50000));
            //set.add(i);
        }

        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);

        System.out.println("Standard deviation: " + set.getBucketSizeStandardDev());
        System.out.println("Load Factor: " + set.getLoadFactor());
    }
}
