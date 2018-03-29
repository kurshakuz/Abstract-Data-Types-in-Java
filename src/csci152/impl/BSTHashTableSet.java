package csci152.impl;

import csci152.adt.HashTableSet;
import csci152.adt.HashTableStats;
import csci152.adt.Set;

import java.util.Objects;

import static java.lang.Math.abs;

public class BSTHashTableSet<T extends Comparable> implements HashTableSet<T> {

    private BST2Set<T>[] buckets;
    private int size;
    private int k;

    public BSTHashTableSet(int numberOfBuckets) {
        buckets = new BST2Set[numberOfBuckets];
        size = 0;
        k = numberOfBuckets;
    }

    @Override
    public int getNumberOfBuckets() {
        return k;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return (size / k);
    }

    @Override
    public double getBucketSizeStandardDev() {
        int sumOfSizes = 0;
        double sumOfDifferences = 0;
        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfSizes += size;
        }
        double meanSize = (sumOfSizes/k);
        //System.out.println(meanSize);

        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfDifferences += (Math.pow((meanSize - size), 2));
            //System.out.println("!" + sumOfDifferences + "!");
        }

        return Math.sqrt(sumOfDifferences/k);
    }

    @Override
    public String bucketsToString() {
        return null;
    }

    @Override
    public void add(T value) {
        int hash = value.hashCode();
        hash = abs(hash);
        if (!contains(value)) {
            int index = (hash % k);
            if (buckets[index] == null) {
                buckets[index] = new BST2Set();
                buckets[index].add(value);
                size++;
            } else {
                buckets[index].add(value);
                size++;
            }
        }
    }

    @Override
    public boolean contains(T value) {
        int hash = abs(value.hashCode());
        int index = (hash % k);
        boolean result = false;
        if (getSize() == 0) return false;
        if (buckets[index] == null) return false;
        result = buckets[index].contains(value);
        return result;
    }

    @Override
    public boolean remove(T value) {
        boolean result = false;
        if (!contains(value)) {
            return false;
        } else {
            int hash = abs(value.hashCode());
            int index = (hash % k);
            //for (int i = 0; i < buckets[index].getSize(); i++) {
                result = buckets[index].remove(value);
                if (result == true) {
                    size--;
                }
            //}
            return result;
        }
    }

    @Override
    public T removeAny() throws Exception {
        T temp = null;
        if (getSize() == 0) throw new Exception("Set is empty!");

        for (int i = 0; i < k; i++) {
            if (buckets[i].getSize() != 0) {
                temp = buckets[i].removeAny();
                //System.out.println("removed " + temp);
                size--;
                break;
            }
        }
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new BST2Set[k];
        size = 0;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < k; i++) {
            if (buckets[i] == null) {
                result += " " + "\n";
            } else {
                result += buckets[i] + "\n";
            }
        }

        result += "Size: " + size;
        return result;
    }
}
