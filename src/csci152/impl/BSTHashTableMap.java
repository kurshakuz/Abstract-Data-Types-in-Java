package csci152.impl;

import csci152.adt.HashTableMap;
import csci152.adt.KeyValuePair;

import static java.lang.Math.abs;

public class BSTHashTableMap<K extends Comparable, V> implements HashTableMap<K, V>{

    private BSTMap<K, V>[] buckets;
    private int size;
    private int k;

    public BSTHashTableMap(int numberOfBuckets) {
        buckets = new BSTMap[numberOfBuckets];
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

        for (int i = 0; i < k; i++) {
            int size;
            if (buckets[i] == null) {
                size = 0;
            } else {
                size = buckets[i].getSize();
            }
            sumOfDifferences += (Math.pow((meanSize - size), 2));
        }

        return Math.sqrt(sumOfDifferences/k);
    }

    @Override
    public String bucketsToString() {
        String result = "";

        for(int i = 0; i < k; i++) {
            if (buckets[i] == null) {
                result += " " + "\n";
            } else {
                result += buckets[i] + "\n";
            }
        }
        result += "Size: " + size;
        return result;
    }

    @Override
    public void define(K key, V value) {
        int hash = key.hashCode();
        hash = abs(hash);
        KeyValuePair pair = new KeyValuePair(key, value);

        if (!contains(key)) {
            int index = (hash % k);
            if (buckets[index] == null) {
                buckets[index] = new BSTMap();
                buckets[index].define(key, value);
                size++;
            } else {
                buckets[index].define(key, value);
                size++;
            }
        }
    }

    public boolean contains(K key) {
        int hash = abs(key.hashCode());
        int index = (hash % k);
        boolean result = false;
        if (getSize() == 0) return false;
        if (buckets[index] == null) return false;

        return buckets[index].contains(key);
    }

//    private boolean containsHelper(BSTSet<KeyValuePair<K, V>> set, K key) {
//        boolean check;
//        set.
//
//        if (node == null) {
//            return false;
//        }
//
//        if (node.getValue().getKey().compareTo(key) > 0) {
//            check = containsHelper(node.getLeft(), key);
//        } else {
//            check = containsHelper(node.getRight(), key);
//        }
//
//        if (node.getValue().getKey().equals(key)) {
//            check = true;
//        }
//
//        return check;
//    }

    @Override
    public V getValue(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        V result = null;
        KeyValuePair pair = new KeyValuePair(key, null);
        if (!contains(key)) {
            return null;
        } else {
            int hash = abs(key.hashCode());
            int index = (hash % k);
            if (buckets[index].contains(key)) {
                result = (V)pair.getValue();
                buckets[index].remove(key);
                size--;
            }
            return result;
        }
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        KeyValuePair<K, V> temp = null;
        if (getSize() == 0) throw new Exception("Map is empty!");

        for (int i = 0; i < k; i++) {
            if (buckets[i].getSize() != 0) {
                temp = buckets[i].removeAny();
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
        buckets = new BSTMap[k];
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
