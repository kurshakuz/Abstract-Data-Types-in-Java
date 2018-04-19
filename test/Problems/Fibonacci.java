package Problems;

import csci152.adt.Map;
import csci152.impl.LLQHashTableMap;

public class Fibonacci {

    private static int callCount1;

    public static long fibCalc1(int n) {

        if (n <= 2) {
            return 1;
        }
        callCount1++;
        return (fibCalc1(n - 1) + fibCalc1(n - 2));
    }

    public static void testFibCalc1(int n) {
        callCount1 = 0;
        System.out.println("fibCalc1(" + n + ") = " + fibCalc1(n)
                + "; takes " + callCount1 + " calls.");
    }

    /////////////////////////
    // Version Two
    /////////////////////////
    private static int callCount2;
    private static Map<Integer, Long> ansMap = new LLQHashTableMap(5);

    public static long fibCalc2(int n) {

        callCount2++;

        if (n < 2) {
            return 1;
        }

        if (ansMap.getValue(n) != null) {
            return ansMap.getValue(n);
        } else {
            long x = fibCalc2(n - 1) + fibCalc2(n - 2);
            ansMap.define(n, x);
            return x;
        }

//        ansMap.define(n-1, fibCalc2(n - 1));
//        ansMap.define(n-2, fibCalc2(n - 2));
    }

    public static void testFibCalc2(int n) {
        callCount2 = 0;

        System.out.println("fibCalc2(" + n + ") = " + fibCalc2(n)
                + "; takes " + callCount2 + " calls.");
    }

    ///////////
    public static void main(String[] args) {

        for (int x = 0; x < 30; x++) {
            testFibCalc1(x);
        }

        for (int x = 0; x < 30; x++) {
            testFibCalc2(x);
        }

    }
}
